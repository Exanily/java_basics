package ru.skillbox;

public final class CPU {
    private final int frequency;
    private final int amountCores;
    private final String manufacturer;
    private final double weight;


    public CPU(int frequency, int amountCores, String manufacturer, double weight) {
        this.frequency = frequency;
        this.amountCores = amountCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public CPU setCPU(int frequency, int amountCores, String manufacturer, double weight) {
        return new CPU(frequency, amountCores, manufacturer, weight);
    }

    public int getFrequency() {
        return frequency;
    }

    public int getAmountCores() {
        return amountCores;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\nПроцессор :" +
                "\n  частота : " + getFrequency() +
                "\n  количество ядер : " + getAmountCores() +
                "\n  производитель : " + getManufacturer() +
                "\n  вес (кг): " + getWeight();
    }
}
