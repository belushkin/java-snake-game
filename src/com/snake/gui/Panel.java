package com.snake.gui;

import com.snake.util.Timer;

import javax.swing.*;

public class Panel {
    private final JPanel jPanel;
    private final JLabel[][] jLabel;
    private final int areaSize;

    public Panel(JPanel jPanel, JLabel[][] jLabel, int areaSize) {
        this.jPanel = jPanel;
        this.jLabel = jLabel;
        this.areaSize = areaSize;

        this.jPanel.setBackground(Colors.BG_COLOR.getColor());
        reset(true);
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void updatePosition() {
        jLabel[game.getX(0)][game.getY(0)].setForeground(Colors.BG_COLOR.getColor());
        jLabel[game.getHeadX()][game.getHeadY()].setForeground(Colors.SNAKE_COLOR.getColor());
    }

    public void blink() {
        jLabel[game.getHeadX()][game.getHeadY()].setForeground(Colors.FOOD_COLOR.getColor());
        Timer.waitInterval(TIMER);
        jLabel[game.getHeadX()][game.getHeadY()].setForeground(Colors.SNAKE_COLOR.getColor());
    }

    public void endAnimation() {
        for (int a = 0; a < game.getLength() - 1; a++) {
            jLabel[game.getX(a)][game.getY(a)].setForeground(Colors.BG_COLOR.getColor());
        }
        Timer.waitInterval(80);
        for (int a = 0; a < game.getLength() - 1; a++) {
            jLabel[game.getX(a)][game.getY(a)].setForeground(Colors.SNAKE_COLOR.getColor());
        }
        Timer.waitInterval(40);
        for (int a = 0; a < game.getLength() - 1; a++) {
            jLabel[game.getX(a)][game.getY(a)].setForeground(Colors.GRAY_COLOR.getColor());
        }
        Timer.waitInterval(500);
    }

    public void setFoodPos(int x, int y) {
        jLabel[x][y].setForeground(Colors.FOOD_COLOR.getColor());
    }

    public void removeFood(int x, int y) {
        jLabel[x][y].setForeground(Colors.BG_COLOR.getColor());
    }

    public void reset(boolean force) {
        int x = 0;
        int y = 0;
        while (y < areaSize - 1) {
            if (force) {
                jLabel[x][y] = new JLabel();
                jLabel[x][y].setText("■");
                jPanel.add(jLabel[x][y]);
            }
            jLabel[x][y].setForeground(Colors.BG_COLOR.getColor());
            x++;
            if (x == areaSize - 1 && y < areaSize - 1) {
                x = 0;
                y++;
            }
        }
    }
}
