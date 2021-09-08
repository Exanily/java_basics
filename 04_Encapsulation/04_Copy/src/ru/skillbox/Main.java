package ru.skillbox;

public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(5,7,10);
        Cargo cargo = new Cargo(dimensions, 350, "Russia, Moscow",
                true, "FLE734er", false);
        System.out.println(cargo);
        System.out.println();
        Cargo copy = new Cargo(cargo.getDimensions(),
                cargo.getWeight(),
                cargo.getDeliveryAddress(),
                cargo.getOverturn(),
                cargo.getRegistrationNumber(),
                cargo.getFragileCargo()
        );
        Dimensions dimensions2 = new Dimensions(6,6,6);
        copy = copy.setDeliveryAddress("Russia, Samara").setWeight(360).setDimensions(dimensions2);
        System.out.println(copy);

    }
}
