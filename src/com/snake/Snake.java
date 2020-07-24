package com.snake;

public class Snake {
    private int[] x, y;
    private int length;
    private int foodX = -1, foodY = -1;

    public Snake() {
    }

    public int getLength() {
        return length;
    }

    public int getX(int i) {
        return x[i];
    }

    public int getY(int i) {
        return y[i];
    }

    public void setPos(int a, int b) {
        x[length] = a;
        y[length] = b;
        for (int i = 0; i < length; i++) {
            x[i] = x[i + 1];
            y[i] = y[i + 1];
        }
    }

    public void setFood(int x, int y) {
        foodX = x;
        foodY = y;
    }

    public void growLength(int i) {
        this.length += 2;
        while (i < this.length) {
            x[i + 1] = x[i];
            y[i + 1] = y[i];
            i++;
        }
    }

    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public void initializeGame(int size) {
        length = 6;

        x = new int[size*size];
        y = new int[size*size];

        foodX = -1;
        foodY = -1;
    }

}
