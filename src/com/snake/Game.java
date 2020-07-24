package com.snake;

import com.snake.gui.Frame;
import com.snake.gui.Panel;
import com.snake.gui.Gui;
import com.snake.gui.events.Key;
import com.snake.gui.events.Action;
import com.snake.util.Randomizer;

import javax.swing.*;
import java.awt.*;

public class Game {

    private Snake snake;
    private Gui gui;
    private Panel panel;
    private final int areaSize;
    private String direction;

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

//        gui = new Gui(
//                panel.getjPanel(),
//                frame.getFrame(),
//                this
//        );

        //        pathfinder = new Pathfinder(this, gui);

        resetAll();
//        gui.init(areaSize);
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
        for (int i = 0; i < (snake.getLength() - 3); i++) {
            if (getHeadX() == snake.getX(i) && getHeadY() == snake.getY(i)) {
//                gui.endAnimation();
                resetAll();
                break;
            }
        }
    }

    private void checkFood(int x, int y) {
        if (snake.getFoodX() == x && snake.getFoodY() == y) {
            snake.growLength(snake.getLength());
//            gui.blink();
            spawnFood();
        }
    }

    public void resetAll() {
        snake.initializeGame(areaSize);
//        gui.resetGUI();
        start();
    }

    public void spawnFood() {
        int x = Randomizer.getRand(areaSize);
        int y = Randomizer.getRand(areaSize);

        if (checkFoodCollision(x, y) == 0) {
            snake.setFood(x, y);
            panel.setFoodPos(x, y);
        } else {
            spawnFood();
        }
    }

    private int checkFoodCollision(int x, int y) {
        for (int i = 1; i < snake.getLength(); i++) {
            if (x == snake.getX(i) && y == snake.getY(i)) {
                return 1;
            }
        }
        return 0;
    }

    public void start() {
//        this.x = areaSize / 2;
//        this.y = areaSize / 2;
        setDirection("LEFT");
        spawnFood();
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

    public int getHeadX() {
        return snake.getX(snake.getLength());
    }

    public int getHeadY() {
        return snake.getY(snake.getLength());
    }

    public int getX(int i) {
        return snake.getX(i);
    }

    public int getY(int i) {
        return snake.getY(i);
    }

    public int getFoodX() {
        return snake.getFoodX();
    }

    public int getFoodY() {
        return snake.getFoodY();
    }

    public int getLength() {
        return snake.getLength();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
