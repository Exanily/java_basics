package ru.skillbox;

public final class HDD {
    private final HDDtype type;
    private final int memory;
    private final double weight;

    public HDD(HDDtype type, int memory, double weight) {
        this.type = type;
        this.memory = memory;
        this.weight = weight;
    }

    public HDD setHDD(HDDtype type, int memory, double weight) {
        return new HDD(type, memory, weight);
    }

    public HDDtype getType() {
        return type;
    }

    public int getMemory() {
        return memory;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\nЖёсткий диск :" +
                "\n  тип : " + getType() +
                "\n  объём : " + getMemory() +
                "\n  вес (кг): " + getWeight();
    }
}
