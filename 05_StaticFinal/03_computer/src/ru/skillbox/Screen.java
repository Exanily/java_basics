package ru.skillbox;

public final class Screen {
    private final int diagonal;
    private final ScreenType type;
    private final double weight;

    public Screen(int diagonal, ScreenType type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public Screen setScreen(int diagonal, ScreenType type, double weight) {
        return new Screen(diagonal, type, weight);
    }

    public int getDiagonal() {
        return diagonal;
    }

    public ScreenType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\nЭкран :" +
                "\n  диагональ : " + getDiagonal() +
                "\n  тип : " + getType() +
                "\n  вес (кг): " + getWeight();
    }
}
