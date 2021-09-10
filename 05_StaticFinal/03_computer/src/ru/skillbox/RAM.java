package ru.skillbox;

public final class RAM {
    private final String type;
    private final int volume;
    private final double weight;

    public RAM(String type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }


    public RAM setRAM(String type, int volume, double weight) {
        return new RAM(type, volume, weight);
    }

    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\nОперативная память :" +
                "\n  тип : " + getType() +
                "\n  объём : " + getVolume() +
                "\n  вес (кг): " + getWeight();
    }

}
