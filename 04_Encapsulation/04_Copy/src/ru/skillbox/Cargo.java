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

    public void print() {
        System.out.println("Ширина (м) : " + dimensions.getWidth());
        System.out.println("Высота (м) : " + dimensions.getHeight());
        System.out.println("Длина (м) : " + dimensions.getLength());
        System.out.println("Масса (кг) : " + getWeight());
        System.out.println("Адрес доставки : " + getDeliveryAddress());
        System.out.println("Свойство — можно ли переворачивать : " + getOverturn());
        System.out.println("Регистрационный номер : " + getRegistrationNumber());
        System.out.println("Является ли груз хрупким : " + getFragileCargo());
        System.out.println("Объём груза (м^3): " + dimensions.cargoVolume());
    }
}
