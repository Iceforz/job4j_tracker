package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус движется");
    }

    @Override
    public void passengers(int number) {
        System.out.println("В автобусе" + number + "пассажиров");
    }

    @Override
    public int cost(int petrol) {
        return petrol * 37;
    }
}
