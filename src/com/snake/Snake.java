package com.snake;

public class Snake {
    private int[] x, y;
    private int length;
    private int fX = -1, fY = -1;

    public Snake() {
    }

    public int getLength() {
        return this.length;
    }

    public int getX(int i) {
        return this.x[i];
    }

    public int getY(int i) {
        return this.y[i];
    }

    public void setPos(int a, int b) {
        this.x[length] = a;
        this.y[length] = b;
        for (int i = 0; i < length; i++) {
            this.x[i] = this.x[i + 1];
            this.y[i] = this.y[i + 1];
        }
    }

    public void setFood(int a, int b) {
        this.fX = a;
        this.fY = b;
    }

    public void growLength(int i) {
        this.length += 2;
        while (i < this.length) {
            this.x[i + 1] = this.x[i];
            this.y[i + 1] = this.y[i];
            i++;
        }
    }

    public int getFoodX() {
        return this.fX;
    }

    public int getFoodY() {
        return this.fY;
    }

    public void initializeGame(int SIZE) {
        this.length = 6;
        this.x = new int[SIZE];
        this.y = new int[SIZE];
        fX = -1;
        fY = -1;
    }

}
