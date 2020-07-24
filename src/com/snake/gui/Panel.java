package com.snake.gui;

import com.snake.Food;
import com.snake.Game;
import com.snake.Snake;
import com.snake.util.Timer;

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
        initPanel();
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

    public void blink(Snake snake) {
        jLabel[snake.getHeadY()][snake.getHeadX()].
                setForeground(Colors.FOOD_COLOR.getColor());

        Timer.waitInterval(Game.TIMER);

        jLabel[snake.getHeadY()][snake.getHeadX()].
                setForeground(Colors.SNAKE_COLOR.getColor());
    }

    public void endAnimation(Snake snake) {
        for (int i = 0; i < snake.getLength() - 1; i++) {
            jLabel[snake.getY(i)][snake.getX(i)].
                    setForeground(Colors.BG_COLOR.getColor());
        }

        Timer.waitInterval(80);
        for (int i = 0; i < snake.getLength() - 1; i++) {
            jLabel[snake.getY(i)][snake.getX(i)].
                    setForeground(Colors.SNAKE_COLOR.getColor());
        }

        Timer.waitInterval(40);
        for (int i = 0; i < snake.getLength() - 1; i++) {
            jLabel[snake.getY(i)][snake.getX(i)].
                    setForeground(Colors.GRAY_COLOR.getColor());
        }
        Timer.waitInterval(500);
    }

    public void displayFood(Food food) {
        jLabel[food.getY()][food.getX()].
                setForeground(Colors.FOOD_COLOR.getColor());
    }

    public void initPanel() {
        for (int i = 0; i < game.getAreaSize(); i++) {
            for (int j = 0; j < game.getAreaSize(); j++) {
                jLabel[i][j] = new JLabel();
                jLabel[i][j].setText("■");
                jLabel[i][j].setForeground(Colors.BG_COLOR.getColor());

                jPanel.add(jLabel[i][j]);
            }
        }
    }

    public void resetPanel() {
        for (int i = 0; i < game.getAreaSize(); i++) {
            for (int j = 0; j < game.getAreaSize(); j++) {
                jLabel[i][j].setForeground(Colors.BG_COLOR.getColor());
            }
        }
    }
}
