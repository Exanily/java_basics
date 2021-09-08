package ru.skillbox;

public class Cargo {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean overturn;
    private final String registrationNumber;
    private final boolean fragileCargo;

    public Cargo(Dimensions dimensions, double weight, String deliveryAddress,
                 boolean overturn, String registrationNumber, boolean fragileCargo) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.overturn = overturn;
        this.registrationNumber = registrationNumber;
        this.fragileCargo = fragileCargo;
    }

    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions, weight, deliveryAddress, overturn, registrationNumber, fragileCargo);
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress, overturn, registrationNumber, fragileCargo);
    }

    public Cargo setWeight(double weight) {
        return new Cargo(dimensions, weight, deliveryAddress, overturn, registrationNumber, fragileCargo);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean getOverturn() {
        return overturn;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean getFragileCargo() {
        return fragileCargo;
    }

    public String toString() {
        return "Ширина (м) : " + dimensions.getWidth() + "\n" +
                "Высота (м) : " + dimensions.getHeight() + "\n" +
                "Длина (м) : " + dimensions.getLength() + "\n" +
                "Масса (кг) : " + getWeight() + "\n" +
                "Адрес доставки : " + getDeliveryAddress() + "\n" +
                "Свойство — можно ли переворачивать : " + getOverturn() + "\n" +
                "Регистрационный номер : " + getRegistrationNumber() + "\n" +
                "Является ли груз хрупким : " + getFragileCargo() + "\n" +
                "Объём груза (м^3): " + dimensions.cargoVolume();
    }
}
