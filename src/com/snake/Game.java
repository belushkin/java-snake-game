package com.snake;

import com.snake.gui.Frame;
import com.snake.gui.Panel;
import com.snake.gui.Gui;
import com.snake.gui.events.Key;
import com.snake.gui.events.Action;
import com.snake.moves.Moves;
import com.snake.util.FoodCollisionDetector;
import com.snake.util.Randomizer;

import javax.swing.*;
import java.awt.*;

public class Game {

    private Snake snake;
//    private Gui gui;
    private Panel panel;
    private Food food;
    private final int areaSize;
    private String direction;
    private int x, y;
    private boolean mvlock;

//    private Pathfinder pathfinder;

    public Game(int areaSize) {
        this.areaSize = areaSize;
    }

    public void run() {
        snake = new Snake();
        panel = new Panel(
                new JPanel(new GridLayout(areaSize, areaSize)),
                new JLabel[areaSize][areaSize],
                areaSize
        );
        Key.addKeyEvents(panel);
        Action.addActionEvents(panel, this);

        Frame frame = new Frame(new JFrame(), panel.getjPanel(), areaSize);

        //        pathfinder = new Pathfinder(this, gui);

        resetAll();
    }

    public void setCoord(int x, int y) { //asetetaan uusi koordinaatti guihin ja pelin sisäiseen logiikkaan
        snake.setPos(x, y);
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
        int snakeHeadX = snake.getX(snake.getLength());
        int snakeHeadY = snake.getY(snake.getLength());

        for (int i = 0; i < (snake.getLength() - 3); i++) {
            if (snakeHeadX == snake.getX(i) && snakeHeadY == snake.getY(i)) {
//                gui.endAnimation();
                resetAll();
                break;
            }
        }
    }

    private void checkFood(int x, int y) {
        if (food.getX() == x && food.getY() == y) {
            snake.growLength(snake.getLength());
//            gui.blink();
            spawnFood();
        }
    }

    public void resetAll() {
        x = areaSize / 2;
        y = areaSize / 2;
        snake.initializeGame(areaSize);
//        gui.resetGUI();
        start();
    }

    public void spawnFood() {
        food = Food.spawn(this);
        getPanel().displayFood(food.getX(), food.getY());
//        snake.setFood(food.getX(), food.getY());
    }

    public void start() {
        setDirection(Moves.LEFT.getMove());
        spawnFood();

//        moveLeft();

//        while (!"".equals(movedir)) {
//            switch (movedir) {
//                case "UP":
//                    moveUp();
//                    break;
//                case "DOWN":
//                    moveDown();
//                    break;
//                case "LEFT":
//                    moveLeft();
//                    break;
//                case "RIGHT":
//                    moveRight();
//                    break;
//                case "":
//                    break;
//            }
//        }
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

    public boolean isMvlock() {
        return mvlock;
    }

    public void setMvlock(boolean mvlock) {
        this.mvlock = mvlock;
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
