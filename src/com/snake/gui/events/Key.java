package com.snake.gui.events;

import com.snake.gui.Panel;
import com.snake.moves.Moves;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Key {
    public static void addKeyEvents(Panel panel) {
        panel.getjPanel().
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
                        Moves.UP.getKey()
                );
        panel.getjPanel().
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),
                        Moves.LEFT.getKey()
                );
        panel.getjPanel().
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
                        Moves.DOWN.getKey()
                );
        panel.getjPanel().
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0),
                        Moves.RIGHT.getKey()
                );
        panel.getjPanel().
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_A, 0),
                        Moves.AUTO.getKey()
                );
    }

}
