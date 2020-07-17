package com.snake;

public class Main {

    static int areaSize = 34;
    static Game game;

    public static void main(String[] args) {
        game = new Game(areaSize);
        game.run();
    }
}
