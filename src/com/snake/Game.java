package com.snake;

import com.snake.gui.Frame;
import com.snake.gui.Panel;
import com.snake.gui.events.Key;
import com.snake.gui.events.Action;
import com.snake.moves.Moves;

import javax.swing.*;
import java.awt.*;

public class Game {

    public static final int TIMER = 200;

    private Snake snake;
    private Food food;
    private Panel panel;

    private final int areaSize;
    private String direction;
    private int x, y;

    private boolean keyPressed;

//    private Pathfinder pathfinder;

    public Game(int areaSize) {
        this.areaSize = areaSize;
    }

    public void run() {
        panel = new Panel(
                new JPanel(new GridLayout(getAreaSize(), getAreaSize())),
                new JLabel[getAreaSize()][getAreaSize()],
                this
        );
        Key.addKeyEvents(panel);
        Action.addActionEvents(panel, this);

        new Frame(new JFrame(), panel.getjPanel(), getAreaSize());

        //        pathfinder = new Pathfinder(this, gui);

        resetGame();
        spawnFood();
        start();
    }

    public void setSnakeCoordinates(int x, int y) {
        snake.setNewCoordinates(x, y);
        checkCollision();
        checkFood(x, y);
//        if (gui.isAutopilot()) {
//            if (!pathfinder.isPathFound()) {
//                pathfinder.initPathfind(getFoodX(), getFoodY());
//            }
//            if (pathfinder.isPathFound()) {
//                pathfinder.traversePath();
//            }
//        }
    }

    private void checkCollision() {
        for (int i = 0; i < (snake.getLength() - 1); i++) {
            if (snake.getHeadX() == snake.getX(i) && snake.getHeadY() == snake.getY(i)) {
                getPanel().endAnimation(snake);
                resetGame();
                spawnFood();
                break;
            }
        }
    }

    private void checkFood(int x, int y) {
        if (food.getX() == x && food.getY() == y) {
            snake.growLength();
            getPanel().blink(snake);
            spawnFood();
        }
    }

    public void resetGame() {
        x = getAreaSize() / 2;
        y = getAreaSize() / 2;
        snake = new Snake();
        getPanel().resetPanel();
    }

    public void spawnFood() {
        food = Food.spawn(this);
        getPanel().displayFood(food);
    }

    public void start() {
        setDirection(Moves.LEFT.getKey());

        while (!getDirection().equals("")) {
            switch (getDirection()) {
                case "UP":
                    Moves.UP.getMove().move(this);
                    break;
                case "DOWN":
                    Moves.DOWN.getMove().move(this);
                    break;
                case "LEFT":
                    Moves.LEFT.getMove().move(this);
                    break;
                case "RIGHT":
                    Moves.RIGHT.getMove().move(this);
                    break;
                case "":
                    break;
            }
        }
    }

//    public int getX(int i) {
//        return snake.getX(i);
//    }
//
//    public int getY(int i) {
//        return snake.getY(i);
//    }
//
//    public int getFoodX() {
//        return snake.getFoodX();
//    }
//
//    public int getFoodY() {
//        return snake.getFoodY();
//    }
//
//    public int getLength() {
//        return snake.getLength();
//    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isKeyPressed() {
        return keyPressed;
    }

    public void setKeyPressed(boolean keyPressed) {
        this.keyPressed = keyPressed;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public Snake getSnake() {
        return snake;
    }

    public Panel getPanel() {
        return panel;
    }
}
