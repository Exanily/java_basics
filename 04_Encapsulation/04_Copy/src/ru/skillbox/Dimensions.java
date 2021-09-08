package ru.skillbox;

public class Dimensions {

    private final double width;
    private final double height;
    private final double length;

    public Dimensions(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Dimensions(){
        this.width = 0;
        this.height = 0;
        this.length = 0;
    }

    public Dimensions setWidth(double width) {
        return new Dimensions(width, height, length);
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(width, height, length);
    }

    public Dimensions setLength(double length) {
        return new Dimensions(width, height, length);
    }


    public Dimensions setDimensions(double width, double height, double length) {
        return new Dimensions(width, height, length);
    }

    public Dimensions getDimensions() {
        return new Dimensions(width, height, length);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double cargoVolume() {
        return width * height * length;
    }
}
