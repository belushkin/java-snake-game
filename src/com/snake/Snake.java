package com.snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snake {

    private final List<Integer> x;
    private final List<Integer> y;

    public Snake() {
        x = new ArrayList<>(Arrays. asList(0, 0, 0, 0, 0));
        y = new ArrayList<>(Arrays. asList(0, 0, 0, 0, 0));
    }

    public void setNewCoordinates(int newX, int newY) {
        for (int i = 0; i < x.size()-1; i++) {
            x.set(i, x.get(i+1));
            y.set(i, y.get(i+1));
        }
        x.set(x.size()-1, newX);
        y.set(y.size()-1, newY);
    }

    public void growLength() {

        x.add(x.get(x.size()-1));
        x.add(x.get(x.size()-1));

        y.add(y.get(y.size()-1));
        y.add(y.get(y.size()-1));


//        length += 2;
//        while (i < length) {
//            x[i + 1] = x[i];
//            y[i + 1] = y[i];
//            i++;
//        }
    }

    public int getLength() {
        return x.size();
    }

    public int getX(int i) {
        return x.get(i);
    }

    public int getY(int i) {
        return y.get(i);
    }

    public int getHeadX() {
        return x.get(x.size()-1);
    }

    public int getHeadY() {
        return y.get(y.size()-1);
    }

    public int getTailX() {
        return x.get(0);
    }

    public int getTailY() {
        return y.get(0);
    }
}
