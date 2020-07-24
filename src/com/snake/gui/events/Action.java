package com.snake.gui.events;

import com.snake.Game;
import com.snake.gui.Panel;
import com.snake.moves.Moves;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Action {

    public static void addActionEvents(Panel panel, Game game) {

        panel.getjPanel().getActionMap().put(Moves.UP.getMove(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println(game.getDirection());
//                System.out.println(Moves.UP);
//                game.setDirection(Moves.UP.getMove());
//                if (!movedir.equals("DOWN")) {
//                    if (!mvlock) {
//                        movedir = "UP";
//                        mvlock = true;
//                    }
//                }
            }
        });
        panel.getjPanel().getActionMap().put(Moves.LEFT.getMove(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println(game.getDirection());
//                game.setDirection("LEFT");
//                if (!movedir.equals("RIGHT")) {
//                    if (!mvlock) {
//                        movedir = "LEFT";
//                        mvlock = true;
//                    }
//                }
            }
        });
        panel.getjPanel().getActionMap().put(Moves.DOWN.getMove(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println(game.getDirection());
//                game.setDirection("DOWN");
//                if (!movedir.equals("UP")) {
//                    if (!mvlock) {
//                        movedir = "DOWN";
//                        mvlock = true;
//                    }
//                }
            }
        });
        panel.getjPanel().getActionMap().put(Moves.RIGHT.getMove(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println(game.getDirection());
//                game.setDirection("RIGHT");
//                if (!movedir.equals("LEFT")) {
//                    if (!mvlock) {
//                        movedir = "RIGHT";
//                        mvlock = true;
//                    }
//                }
            }
        });

        panel.getjPanel().getActionMap().put(Moves.AUTO.getMove(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
//                pilotToggle();
            }
        });

    }
}
