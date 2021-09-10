package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        RAM ram = new RAM("DDDR4", 8, 0.03);
        CPU cpu = new CPU(2500, 8, "Intel", 0.05);
        Screen screen = new Screen(20, ScreenType.IPS, 5);
        Keyboard keyboard = new Keyboard("MEMBRANE", true, 2);
        HDD hdd = new HDD(HDDtype.SSD, 256, 0.1);
        Computer computer = new Computer("HyperPC", "Play", ram, screen, keyboard,hdd,cpu);


        System.out.println(computer);

    }
}
