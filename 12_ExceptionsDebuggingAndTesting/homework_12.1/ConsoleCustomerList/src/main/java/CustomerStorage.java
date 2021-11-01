import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerStorage {
    public static final Pattern PATTERN_MAIL = Pattern.compile("[\\w.-]+@[A-z]+\\.[A-z]+");
    public static final Pattern PATTERN_PHONE = Pattern.compile("\\+[0-9]+");
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n\t" +
            ADD_COMMAND;
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new ArrayIndexOutOfBoundsException(COMMAND_ERROR);
        }
        if (!PATTERN_MAIL.matcher(components[INDEX_EMAIL]).matches()) {
            throw new ArrayIndexOutOfBoundsException("Wrong mail!");
        }
        if (!PATTERN_PHONE.matcher(components[INDEX_PHONE]).matches()) {
            throw new ArrayIndexOutOfBoundsException("Wrong phone!");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}