package com.snake.gui;

import com.snake.Game;

import javax.swing.*;


public class Gui {

    Game game;
    private JLabel[][] screen;
    private final JPanel panel;
    private final JFrame frame;

    private int x, y;
    private String movedir;
    private int areaSize = 34;
    private int TIMER = 50;
    private boolean mvlock;
    private boolean autopilot;

    public Gui(JPanel panel, JFrame frame, Game game) {
        this.panel = panel;
        this.frame = frame;
        this.game = game;
    }

    public void init(int areaSize) {
        this.areaSize = areaSize;
//        this.game = game;

//        this.game.resetAll();
    }



    public void stop() {
        movedir = "";
    }

    public int getGridSize() {
        return this.areaSize;
    }

    public void setTimer(int i) {
        this.TIMER = i;
    }


    private void pilotToggle() {
        autopilot = !isAutopilot();
    }

    public boolean isAutopilot() {
        return autopilot;
    }

    void setMovedir(String mvdir) {
        this.movedir = mvdir;
    }
}
