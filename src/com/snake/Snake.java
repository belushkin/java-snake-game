package com.snake;

public class Snake {
    private final int[] x;
    private final int[] y;
    private int length = 6;

    public Snake(int size) {
        x = new int[size*size];
        y = new int[size*size];
    }

    public void setPos(int newX, int newY) {
        x[length] = newX;
        y[length] = newY;

        for (int i = 0; i < length; i++) {
            x[i] = x[i + 1];
            y[i] = y[i + 1];
        }
//        for (int i = 0; i <= length; i++) {
//            System.out.println(x[i]);
//        }
    }

    public void growLength(int i) {
        length += 2;
        while (i < length) {
            x[i + 1] = x[i];
            y[i + 1] = y[i];
            i++;
        }
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

    public int getHeadX() {
        return x[length];
    }

    public int getHeadY() {
        return y[length];
    }

    public int getTailX() {
        return x[0];
    }

    public int getTailY() {
        return y[0];
    }
}
