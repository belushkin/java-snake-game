package com.snake.util;

public class Randomizer {
    public static int getRand(int areaSize) {
        return (int) (Math.random() * (areaSize - 2));
    }
}
