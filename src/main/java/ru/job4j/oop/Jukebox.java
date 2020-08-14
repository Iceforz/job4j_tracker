package ru.job4j.oop;



public class Jukebox {
    public void music(int position) {
        String song = null;
        if (position == 1) {
            song = "Пусть бегут неуклюже";
        } else if (position == 2) {
            song = "Спокойной ночи";
        } else if (position != 1 || position != 2) {
            song = "Песня не найдена";
        }
        System.out.println(song);
    }

    public static void main(String[] args) {
        Jukebox pleer = new Jukebox();
        int position = 3;
        pleer.music(position);
    }
}


