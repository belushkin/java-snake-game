package com.snake.gui.events;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Key {
    public static JPanel addKeyEvents(JPanel gamepanel) {
        gamepanel.
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
                        "UP"
                );
        gamepanel.
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),
                        "LEFT"
                );
        gamepanel.
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
                        "DOWN"
                );
        gamepanel.
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0),
                        "RIGHT"
                );
        gamepanel.
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_A, 0),
                        "AUTO"
                );

        return gamepanel;
    }

}
