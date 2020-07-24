package com.snake.gui.events;

import com.snake.Game;
import com.snake.gui.Panel;
import com.snake.moves.Moves;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Action {

    public static void addActionEvents(Panel panel, Game game) {

        panel.getjPanel().getActionMap().put(Moves.UP.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println(game.getKey());
//                System.out.println(Moves.UP);
//                game.setDirection(Moves.UP.getKey());
//                if (!movedir.equals("DOWN")) {
//                    if (!mvlock) {
//                        movedir = "UP";
//                        mvlock = true;
//                    }
//                }
            }
        });
        panel.getjPanel().getActionMap().put(Moves.LEFT.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println(game.getKey());
//                game.setDirection("LEFT");
//                if (!movedir.equals("RIGHT")) {
//                    if (!mvlock) {
//                        movedir = "LEFT";
//                        mvlock = true;
//                    }
//                }
            }
        });
        panel.getjPanel().getActionMap().put(Moves.DOWN.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println(game.getKey());
//                game.setDirection("DOWN");
//                if (!movedir.equals("UP")) {
//                    if (!mvlock) {
//                        movedir = "DOWN";
//                        mvlock = true;
//                    }
//                }
            }
        });
        panel.getjPanel().getActionMap().put(Moves.RIGHT.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println(game.getKey());
//                game.setDirection("RIGHT");
//                if (!movedir.equals("LEFT")) {
//                    if (!mvlock) {
//                        movedir = "RIGHT";
//                        mvlock = true;
//                    }
//                }
            }
        });

        panel.getjPanel().getActionMap().put(Moves.AUTO.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                pilotToggle();
            }
        });

    }
}
