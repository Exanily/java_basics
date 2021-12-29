import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        String filename = "images";
        Path pathToFile = Paths.get(filename);
        if (!new File(pathToFile.toString()).exists()) {
            File file = new File(filename);
            if(file.mkdir()){
                System.out.println("Файл " + filename + " создан");
            }
        }
        try {
            Document document = Jsoup.connect("https://lenta.ru").get();
            Elements elements = document.select("div.layout__container").select("img");

            elements.forEach(element -> {
                System.out.println(element.attr("src"));
                int i = element.attr("src").lastIndexOf("/");
                String name = element.attr("src").substring(i);
                try (InputStream in = new URL(element.attr("src")).openStream()) {
                    String s = pathToFile.toAbsolutePath() + name;
                    if (!new File(s).exists()) {
                        Files.copy(in, Path.of(s));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
