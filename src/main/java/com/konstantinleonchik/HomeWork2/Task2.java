package com.konstantinleonchik.HomeWork2;

public class Task2 {
    public static void main(String[] args) {
        Car car1 = new Car("Lada", 170);
        Car car2 = new Car("Lamba", 320);

        try {
            car1.acceleration(50);
            car1.acceleration(80);
            car1.acceleration(50);
        } catch (WeakEngineException e) {
            System.out.println(e);
        }
    }
}