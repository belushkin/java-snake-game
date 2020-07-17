package com.snake;

import com.snake.gui.Frame;
import com.snake.gui.Panel;
import com.snake.gui.Gui;
import com.snake.gui.Screen;

import javax.swing.*;
import java.awt.*;

public class Game {

    private Snake snake;
    private Gui gui;
    private final int areaSize;
//    private Pathfinder pathfinder;

    public Game(int areaSize) {
        this.areaSize = areaSize;
    }

    public void run() {
        snake = new Snake();
        Panel panel = new Panel(
                new JPanel(new GridLayout(areaSize, areaSize)),
                new JLabel[areaSize][areaSize],
                areaSize
        );
        Frame frame = new Frame(new JFrame(), panel.getjPanel(), areaSize);

        gui = new Gui(
                panel.getjPanel(),
                frame.getFrame(),
                this
        );

        //        pathfinder = new Pathfinder(this, gui);

        gui.init(areaSize);
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
                gui.endAnimation();
                resetAll();
                break;
            }
        }
    }

    private void checkFood(int x, int y) {
        if (snake.getFoodX() == x && snake.getFoodY() == y) {
            snake.growLength(snake.getLength());
            gui.blink();
            gui.setScore();
            spawnFood();
        }
    }

    public void resetAll() {
        snake.initializeGame(gui.getGridSize() * gui.getGridSize());
        gui.resetGUI();
        gui.start();
    }

    public void spawnFood() {
        int x = getRand();
        int y = getRand();
        if (checkFoodCollision(x, y) == 0) {
            snake.setFood(x, y);
            gui.setFoodPos(x, y);
        } else {
            spawnFood();
        }
    }

    private int checkFoodCollision(int x, int y) {
        for (int i = 1; i < (snake.getLength()); i++) {
            if (x == snake.getX(i) && y == snake.getY(i)) {
                return 1;
            }
        }
        return 0;
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

    public int getRand() {
        return (0 + (int) (Math.random() * (((gui.getGridSize() - 2) - 0) + 0)));
    }

}
