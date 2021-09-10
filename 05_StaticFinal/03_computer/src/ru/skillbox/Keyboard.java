package ru.skillbox;

public final class Keyboard {
    private final String type;
    private final boolean backlight;
    private final double weight;

    public Keyboard(String type, boolean backlight, double weight) {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
    }

    public Keyboard setKeyboard(String type, boolean backlight, double weight) {
        return new Keyboard(type, backlight, weight);
    }

    public String getType() {
        return type;
    }

    public boolean isBacklight() {
        return backlight;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\nКлавиатура :" +
                "\n  тип : " + getType() +
                "\n  наличие подсветки : " + isBacklight() +
                "\n  вес (кг): " + getWeight();
    }
}
