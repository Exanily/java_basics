package ru.skillbox;

public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor > minFloor ? currentFloor - 1 : currentFloor;
    }

    public void moveUp() {
        currentFloor = currentFloor + 1;
    }

    public void move(int floor) {
        if (floor == 0) {
            return;
        }

        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Ошибка");
            return;
        }

        if (floor > currentFloor) {
            while (floor > currentFloor) {
                moveUp();
                if (currentFloor != 0){
                    System.out.println("Вы находитесь на " + getCurrentFloor() + " этаже");
                }

            }
        }
        if (floor < currentFloor) {
            while (floor < currentFloor) {
                moveDown();
                if (currentFloor != 0){
                    System.out.println("Вы находитесь на " + getCurrentFloor() + " этаже");
                }
            }
        }
    }
}
