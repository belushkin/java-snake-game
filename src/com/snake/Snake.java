package com.snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake {
    private final int[] x;
    private final int[] y;
    private int length = 6;

    private List<Integer> xE = new ArrayList<>(Arrays. asList(0, 0, 0, 0, 0));
    private List<Integer> yE = new ArrayList<>(Arrays. asList(0, 0, 0, 0, 0));

    public Snake(int size) {
        x = new int[size*size];
        y = new int[size*size];
    }

    public void setPos(int newX, int newY) {
//        x[length] = newX;
//        y[length] = newY;
//
//        for (int i = 0; i < length; i++) {
//            x[i] = x[i + 1];
//            y[i] = y[i + 1];
//        }


        for (int i = 0; i < xE.size()-1; i++) {
            xE.set(i, xE.get(i+1));
            yE.set(i, yE.get(i+1));
        }
        xE.set(xE.size()-1, newX);
        yE.set(yE.size()-1, newY);
        System.out.println(xE);
        System.out.println(yE);
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
//        return x[length];
        return xE.get(xE.size()-1);
    }

    public int getHeadY() {
//        return y[length];
        return yE.get(yE.size()-1);
    }

    public int getTailX() {
//        return x[0];
        return xE.get(0);
    }

    public int getTailY() {
//        return y[0];
        return yE.get(0);
    }
}
