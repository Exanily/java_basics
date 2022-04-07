package com.skillbox.redisdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.System.out;

public class RedisTest {

    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis

    // Для теста будем считать неактивными пользователей, которые не заходили 2 секунды
    private static final int DELETE_SECONDS_AGO = 2;

    // Допустим пользователи делают 500 запросов к сайту в секунду
    private static final int RPS = 20;

    // И всего на сайт заходило 1000 различных пользователей
    private static final int USERS = 1000;

    // Также мы добавим задержку между посещениями
    private static final int SLEEP = 1; // 1 миллисекунда

    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");

    private static void log(int UsersOnline) {
        out.println("— На главной странице показываем пользователя: " + UsersOnline);
    }

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();
        // Эмулируем 10 секунд работы сайта
        for (int seconds = 0; seconds < 10; seconds++) {
            // Выполним 500 запросов
            for (int request = 1; request <= RPS; request++) {
                redis.logPageVisit(request);
                Thread.sleep(SLEEP);
            }
            for (int i = 0; i < RPS; i++) {
                int user = redis.getPollFirst();
                if (getPaid()) {
                    user = getRandomUser();
                }
                log(user);
                redis.add(user);
                Thread.sleep(SLEEP);
            }
            Thread.sleep(1000);
        }
        redis.shutdown();
    }

    private static int getRandomUser() {
        int random = new Random().nextInt(20) + 1;
        out.println("> Пользователь " + random + " оплатил платную услугу");
        return random;
    }

    private static boolean getPaid() {
        int random = new Random().nextInt(10);
        return random == 5;
    }
}
