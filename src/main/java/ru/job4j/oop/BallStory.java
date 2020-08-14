package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare brown = new Hare();
        Wolf black = new Wolf();
        Fox orange = new Fox();
        brown.tryEat(ball);
        black.tryEat(ball);
        orange.tryEat(ball);
        ball.tryEat(ball);
    }
}
