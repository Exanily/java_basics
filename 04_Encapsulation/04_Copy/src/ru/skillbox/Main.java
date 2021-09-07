package ru.skillbox;

public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(30, 15, 20);
        Cargo cargo = new Cargo(dimensions, 350, "Russia, Moscow",
                true, "FLE734er", false);
        dimensions.setDimensions(45, 25, 50);
        Cargo copy = new Cargo(dimensions,
                cargo.getWeight(),
                cargo.getDeliveryAddress(),
                cargo.getOverturn(),
                cargo.getRegistrationNumber(),
                cargo.getFragileCargo());
        cargo.print();
        System.out.println();
        copy.print();
        //Cargo copy = cargo.setDeliveryAddress("Russia, Samara");


    }
}
