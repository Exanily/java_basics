package ru.skillbox;

public class Car {
    private String brand;
    private String model;
    private boolean automaticTransmission;
    private int maxSpeed;

    public Car(String brand,String model){
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean getAutomaticTransmission() {
        return automaticTransmission;
    }

    public void setAutomaticTransmission(boolean automaticTransmission) {
        this.automaticTransmission = automaticTransmission;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void print(){
        System.out.println("Бренд : " + getBrand());
        System.out.println("Модель : " + getModel());
        System.out.println("Максимальная скорость : " + getMaxSpeed());
        System.out.println("Автоматическая коробка передач : " + getAutomaticTransmission());
    }
}
