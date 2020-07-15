package com.snake.game;

/**
 *
 * @author antti
 */
public class Main {

    static int areaSize = 34;
    static Game game = null;

    public static void main(String[] args) {
        game = new Game();
        game.init(areaSize);
    }
}
