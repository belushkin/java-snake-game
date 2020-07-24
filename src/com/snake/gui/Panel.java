package com.snake.gui;

import com.snake.Food;
import com.snake.Game;
import com.snake.Snake;

import javax.swing.*;

public class Panel {
    private final JPanel jPanel;
    private final JLabel[][] jLabel;
    private final Game game;

    public Panel(JPanel jPanel, JLabel[][] jLabel, Game game) {
        this.jPanel = jPanel;
        this.jLabel = jLabel;
        this.game = game;

        this.jPanel.setBackground(Colors.BG_COLOR.getColor());
        resetPanel();
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void highlight(Snake snake) {
        jLabel[snake.getHeadY()][snake.getHeadX()].
                setForeground(Colors.SNAKE_COLOR.getColor());

        jLabel[snake.getTailY()][snake.getTailX()].
                setForeground(Colors.BG_COLOR.getColor());
    }

    public void blink() {
//        jLabel[game.getHeadX()][game.getHeadY()].setForeground(Colors.FOOD_COLOR.getColor());
//        Timer.waitInterval(TIMER);
//        jLabel[game.getHeadX()][game.getHeadY()].setForeground(Colors.SNAKE_COLOR.getColor());
    }

    public void endAnimation() {
//        for (int a = 0; a < game.getLength() - 1; a++) {
//            jLabel[game.getX(a)][game.getY(a)].setForeground(Colors.BG_COLOR.getColor());
//        }
//        Timer.waitInterval(80);
//        for (int a = 0; a < game.getLength() - 1; a++) {
//            jLabel[game.getX(a)][game.getY(a)].setForeground(Colors.SNAKE_COLOR.getColor());
//        }
//        Timer.waitInterval(40);
//        for (int a = 0; a < game.getLength() - 1; a++) {
//            jLabel[game.getX(a)][game.getY(a)].setForeground(Colors.GRAY_COLOR.getColor());
//        }
//        Timer.waitInterval(500);
    }

    public void displayFood(Food food) {
        jLabel[food.getY()][food.getX()].
                setForeground(Colors.FOOD_COLOR.getColor());
    }

//    public void reset(boolean force) {
//        int x = 0;
//        int y = 0;
//        while (y < game.getAreaSize() - 1) {
//            if (force) {
//                jLabel[x][y] = new JLabel();
//                jLabel[x][y].setText("■");
//                jPanel.add(jLabel[x][y]);
//            }
//            jLabel[x][y].setForeground(Colors.BG_COLOR.getColor());
//            x++;
//            if (x == game.getAreaSize() - 1 && y < game.getAreaSize() - 1) {
//                x = 0;
//                y++;
//            }
//        }
//    }

    public void resetPanel() {
        for (int i = 0; i < game.getAreaSize(); i++) {
            for (int j = 0; j < game.getAreaSize(); j++) {
                jLabel[i][j] = new JLabel();
                jLabel[i][j].setText("■");
                jLabel[i][j].setForeground(Colors.BG_COLOR.getColor());

                jPanel.add(jLabel[i][j]);
            }
        }
    }
}
