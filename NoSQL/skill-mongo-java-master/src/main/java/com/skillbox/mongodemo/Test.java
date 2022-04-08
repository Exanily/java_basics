package com.skillbox.mongodemo;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String COURSES = "courses";

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        MongoDatabase database = mongoClient.getDatabase("local");

        // Создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("TestSkillDemo");

        // Удалим из нее все документы
        collection.drop();

        File file = new File(Test.class.getClassLoader().getResource("mongo.csv").getFile()
        );
        List<List<String>> records = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(file));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < records.size(); i++) {
            List<String> courses;
            courses = Arrays.asList(records.get(i).get(2).split(","));

            Document firstDocument = new Document()
                    .append(NAME, records.get(i).get(0))
                    .append(AGE, Integer.valueOf(records.get(i).get(1)))
                    .append(COURSES, courses);


            collection.insertOne(firstDocument);
        }

        int countStudents = (int) collection.count();
        System.out.println("Студентов в базе : " + countStudents);

        BsonDocument year = BsonDocument.parse("{age: {$gt: 40}}");
        int countYears = (int) collection.countDocuments(year);
        System.out.println("Количество студентов старше 40 лет : " + countYears);

        BsonDocument ageSort = BsonDocument.parse("{age: 1}");
        Document student = collection.find().sort(ageSort).first();
        int age = (int) student.get(AGE);
        year = BsonDocument.parse("{age: {$eq:" + age + "}}");
        FindIterable<Document> students = collection.find(year);
        students.forEach((Consumer<Document>) document -> {
            String name = (String) document.get(NAME);
            System.out.println("Имя самого молодого студента : " + name);
        });


        ageSort = BsonDocument.parse("{age: -1}");
        student = collection.find().sort(ageSort).first();
        age = (int) student.get(AGE);
        year = BsonDocument.parse("{age: {$eq:" + age + "}}");
        students = collection.find(year);
        students.forEach((Consumer<Document>) document -> {
            ArrayList<String> courses = (ArrayList<String>) document.get(COURSES);
            System.out.println("Cписок курсов самого старого студента : " + courses);
        });
    }
}
