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
                if (!game.getDirection().equals(Moves.DOWN.getKey()) && !game.isKeyPressed()) {
                    game.setDirection(Moves.UP.getKey());
                    game.setKeyPressed(true);
                }
            }
        });

        panel.getjPanel().getActionMap().put(Moves.LEFT.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!game.getDirection().equals(Moves.RIGHT.getKey()) && !game.isKeyPressed()) {
                    game.setDirection(Moves.LEFT.getKey());
                    game.setKeyPressed(true);
                }
            }
        });

        panel.getjPanel().getActionMap().put(Moves.DOWN.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!game.getDirection().equals(Moves.UP.getKey()) && !game.isKeyPressed()) {
                    game.setDirection(Moves.DOWN.getKey());
                    game.setKeyPressed(true);
                }
            }
        });

        panel.getjPanel().getActionMap().put(Moves.RIGHT.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!game.getDirection().equals(Moves.LEFT.getKey()) && !game.isKeyPressed()) {
                    game.setDirection(Moves.RIGHT.getKey());
                    game.setKeyPressed(true);
                }
            }
        });

        panel.getjPanel().getActionMap().put(Moves.AUTO.getKey(), new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                game.toggleAuto();
            }
        });

    }
}
