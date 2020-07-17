package com.snake.util;

public class Timer {

    public static void waitInterval(int time) {
        if (time > 0) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
