package ru.skillbox;

public class Computer {
    private final String name;
    private final String vendor;
    private final RAM ram;
    private final Screen screen;
    private final Keyboard keyboard;
    private final HDD hdd;
    private final CPU cpu;

    Computer(String vendor, String name, RAM ram, Screen screen, Keyboard keyboard, HDD hdd, CPU cpu) {
        this.name = name;
        this.vendor = vendor;
        this.ram = ram;
        this.screen = screen;
        this.keyboard = keyboard;
        this.hdd = hdd;
        this.cpu = cpu;
    }

    public double totalWeight(){
        return ram.getWeight() + cpu.getWeight() + screen.getWeight() + keyboard.getWeight() + hdd.getWeight();
    }
    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public RAM getRam() {
        return ram;
    }

    public Screen getScreen() {
        return screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public HDD getHdd() {
        return hdd;
    }

    public CPU getCpu() {
        return cpu;
    }

    public String toString() {
        return "Процессор :" +
                    "\n  частота : " + cpu.getFrequency() +
                    "\n  количество ядер : " + cpu.getAmountCores() +
                    "\n  производитель : " + cpu.getManufacturer() +
                    "\n  вес (кг): " + cpu.getWeight() +
                "\nОперативная память :" +
                    "\n  тип : " + ram.getType() +
                    "\n  объём : " + ram.getVolume() +
                    "\n  вес (кг): " + ram.getWeight() +
                "\nЖёсткий диск :" +
                    "\n  тип : " + hdd.getType() +
                    "\n  объём : " + hdd.getMemory() +
                    "\n  вес (кг): " + hdd.getWeight() +
                "\nЭкран :" +
                    "\n  диагональ : " + screen.getDiagonal() +
                    "\n  тип : " + screen.getType() +
                    "\n  вес (кг): " + screen.getWeight() +
                "\nКлавиатура :" +
                    "\n  тип : " + keyboard.getType() +
                    "\n  наличие подсветки : " + keyboard.isBacklight() +
                    "\n  вес (кг): " + keyboard.getWeight()+
                "\n\nОбщая масса компьютера (кг): " + totalWeight()
                ;
    }

}
