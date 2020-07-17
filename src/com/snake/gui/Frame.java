package com.snake.gui;

import javax.swing.*;

public class Frame {
    private JFrame frame;

    public Frame(JFrame frame) {
        this.frame = frame;

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
