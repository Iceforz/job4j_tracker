package ru.job4j.io;
import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sticks = 11;
        boolean game = true;
        System.out.println("Всего " + sticks);
        while (game) {
            System.out.println("1ый игрок");
            int player1 = 2;
            sticks -= player1;
            if (sticks == 0) {
                System.out.println("1ый победил");
            }
            System.out.println("2ой игрок");
            int player2 = Integer.valueOf(scanner.nextLine());
            sticks -= player2;
            if (sticks <= 0) {
                System.out.println("2ой победил");
                break;
            }
            System.out.println("Осталось" + sticks);
        }
    }
}


