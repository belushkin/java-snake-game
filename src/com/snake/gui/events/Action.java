package com.snake.gui.events;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Action {

    public static JPanel addActionEvents(JPanel gamepanel) {

        gamepanel.getActionMap().put("UP", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!movedir.equals("DOWN")) {
                    if (!mvlock) {
                        movedir = "UP";
                        mvlock = true;
                    }
                }
            }
        });
        gamepanel.getActionMap().put("LEFT", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!movedir.equals("RIGHT")) {
                    if (!mvlock) {
                        movedir = "LEFT";
                        mvlock = true;
                    }
                }
            }
        });
        gamepanel.getActionMap().put("DOWN", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!movedir.equals("UP")) {
                    if (!mvlock) {
                        movedir = "DOWN";
                        mvlock = true;
                    }
                }
            }
        });
        gamepanel.getActionMap().put("RIGHT", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!movedir.equals("LEFT")) {
                    if (!mvlock) {
                        movedir = "RIGHT";
                        mvlock = true;
                    }
                }
            }
        });

        gamepanel.getActionMap().put("AUTO", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pilotToggle();
            }
        });

        return gamepanel;
    }
}
