package com.snake.util;

import com.snake.Snake;

public class FoodCollisionDetector {
    public static boolean collide(Snake snake, int foodX, int foodY) {
        for (int i = 1; i < snake.getLength(); i++) {
            if (foodX == snake.getX(i) && foodY == snake.getY(i)) {
                return true;
            }
        }
        return false;
    }
}
