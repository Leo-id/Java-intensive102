package com.konstantinleonchik.HomeWork2;

public class Car {
    String name;
    int speed = 0;
    int max_speed;

    public Car(String name, int mam_speed) {
        this.name = name;
        this.max_speed = mam_speed;
    }

    public int acceleration(int acceleration_pedal) throws WeakEngineException {
        if ((speed + acceleration_pedal) <= max_speed) {
            speed += acceleration_pedal;
            System.out.println("Ускорились до: " + speed);
            return speed;
        } else {
            throw new WeakEngineException("Двигатель слишком слабый, создайте новый автомобиль");
        }
    }
}