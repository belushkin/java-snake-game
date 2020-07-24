package com.snake;

import com.snake.util.FoodCollisionDetector;
import com.snake.util.Randomizer;

public class Food {
    private final int x;
    private final int y;

    private Food(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Food spawn(Game game) {
        int x = Randomizer.getRand(game.getAreaSize());
        int y = Randomizer.getRand(game.getAreaSize());
        Food food;

        if (FoodCollisionDetector.collide(game.getSnake(), x, y)) {
            food = spawn(game);
        } else {
            food = new Food(x, y);
        }
        return food;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
