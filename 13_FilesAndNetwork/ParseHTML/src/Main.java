import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(".jpg");
        arrayList.add(".jpeg");
        arrayList.add(".png");

        String filename = "images";
        Path pathToFile = Paths.get(filename);
        if (!new File(pathToFile.toString()).exists()) {
            File file = new File(filename);
            if (file.mkdir()) {
                System.out.println("Файл " + filename + " создан");
            }
        }
        try {
            Document document = Jsoup.connect("https://lenta.ru").get();
            Elements elements = document.select("div.layout__container").select("img");

            elements.forEach(element -> {
                int i = element.attr("src").lastIndexOf("/");
                String name = element.attr("src").substring(i);
                if (arrayList.contains(name.substring(name.lastIndexOf(".")))) {
                    try (InputStream in = new URL(element.attr("src")).openStream()) {
                        String s = pathToFile.toAbsolutePath() + name;
                        if (!new File(s).exists()) {
                            Files.copy(in, Path.of(s));
                            System.out.println(element.attr("src"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
