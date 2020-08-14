package ru.job4j.oop;



public class DummyDic {
    public String engToRus(String eng) {
        String result = "Неизвестное слово. " + eng;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        DummyDic dummy = new DummyDic();
        String s = "Unknown word";
        String translate = dummy.engToRus(s);
        System.out.println(translate);
    }
    }

