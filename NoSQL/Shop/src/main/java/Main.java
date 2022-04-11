import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.Consumer;

public class Main {
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String ITEMS = "items";
    private static final String SHOPS = "shops";

    private static final MongoClient MONGO_CLIENT = new MongoClient("127.0.0.1", 27017);
    private static final MongoDatabase DATABASE = MONGO_CLIENT.getDatabase("local");
    private static final MongoCollection<Document> COLLECTION_SHOP = DATABASE.getCollection(SHOPS);
    private static final MongoCollection<Document> COLLECTION_ITEM = DATABASE.getCollection(ITEMS);


    private static final String COMMANDS = "Команды:\n" +
            "add_shop [name] - добавить магазин\n" +
            "add_item [name] [price] - добавить товар \n" +
            "add_item_shop [name_item] [name_shop] - добавить товар в магазин\n" +
            "statistic - статистика товаров для каждого магазина\n" +
            "commands - список команд\n" +
            "stop - выход";

    private static final String ERROR = "Данные введены не корректно\n" + COMMANDS;

    public static void main(String[] args) throws IOException {
        commands();
    }

    private static void commands() throws IOException {
        System.out.println(COMMANDS);
        boolean stop = false;
        while (!stop) {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String[] command = in.readLine().trim().toLowerCase(Locale.ROOT).split(" ");

            switch (command[0]) {
                case "add_shop": {
                    if (command.length == 2) {
                        addShop(command[1]);
                    } else System.out.println(ERROR);
                    break;
                }
                case "add_item": {
                    if (command.length == 3) {
                        try {
                            int price = Integer.parseInt(command[2]);
                            addItem(command[1], price);
                        } catch (Exception exception) {
                            System.out.println(ERROR);
                        }
                    } else System.out.println(ERROR);
                    break;
                }
                case "add_item_shop": {
                    if (command.length == 3) {
                        addItemInShop(command[2], command[1]);
                    } else System.out.println(ERROR);
                    break;
                }
                case "statistic": {
                    statistics();
                    break;
                }
                case "commands": {
                    System.out.println(COMMANDS);
                    break;
                }
                case "stop": {
                    stop = true;
                    break;
                }
                default: {
                    System.out.println(ERROR);
                    break;
                }
            }
        }
    }

    private static void addShop(String name) {
        Document document = new Document()
                .append(NAME, toLowerCase(name))
                .append(ITEMS, new ArrayList<>());
        COLLECTION_SHOP.insertOne(document);
        System.out.println("Магазин \"" + name + "\" добавлен");
    }

    private static void addItem(String name, Integer price) {
        Document document = new Document()
                .append(NAME, toLowerCase(name))
                .append(PRICE, price);
        COLLECTION_ITEM.insertOne(document);
        System.out.println("Товар \"" + name + "\" с ценой " + price + "р добавлен");
    }

    private static void addItemInShop(String nameShop, String nameItem) {
        BsonDocument old = BsonDocument.parse("{name : \"" + toLowerCase(nameShop) + "\"}");
        BsonDocument update = BsonDocument.parse("{$push: {items: \"" + toLowerCase(nameItem) + "\"}}");
        COLLECTION_SHOP.updateOne(old, update);
        System.out.println("Товар \"" + nameItem + "\" добавлен в магазин \"" + nameShop + "\"");
    }

    private static void statistics() {
        String count = "count";
        String averagePrice = "averagePrice";
        String minPrice = "minPrice";
        String maxPrice = "maxPrice";
        String less100 = "less100";
        System.out.println("Статистика:");
        AggregateIterable<Document> countItem = COLLECTION_SHOP.aggregate(Arrays.asList(new Document("$lookup",
                        new Document("from", "items")
                                .append("localField", "items")
                                .append("foreignField", "name")
                                .append("as", "array")),
                new Document("$project",
                        new Document("name", 1)
                                .append(count,
                                        new Document("$size", "$array"))
                                .append(averagePrice,
                                        new Document("$avg", "$array.price"))
                                .append(minPrice,
                                        new Document("$min", "$array.price"))
                                .append(maxPrice,
                                        new Document("$max", "$array.price"))
                                .append(less100,
                                        new Document("$size",
                                                new Document("$filter",
                                                        new Document("input", "$array")
                                                                .append("as", "obj")
                                                                .append("cond",
                                                                        new Document("$lt", Arrays.asList("$$obj.price", 100)))))))));
        countItem.forEach((Consumer<Document>) document -> System.out.println(document.get(NAME) +
                "\n\t Общее количество наименований товаров: " + document.get(count) +
                "\n\t Средняя цена товаров: " + document.get(averagePrice) +
                "\n\t Самый дорогой товар: " + document.get(maxPrice) +
                "\n\t Самый дешевый товар: " + document.get(minPrice) +
                "\n\t Количество товаров дешевле 100 рублей: " + document.get(less100)));
    }

    private static String toLowerCase(String s) {
        return s.toLowerCase(Locale.ROOT);
    }
}
