package com.snake.gui;

import javax.swing.*;

public class Frame {
    private final JFrame frame;
    private final int areaSize;

    public Frame(JFrame frame, JPanel jPanel, int areaSize) {
        this.frame = frame;
        this.areaSize = areaSize;

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(jPanel);
        frame.setSize(getFrameSize(), getFrameSize());
        frame.setResizable(false);
    }

    public JFrame getFrame() {
        return frame;
    }

    private int getFrameSize() {
        if (this.areaSize > 29) {
            return this.areaSize * 11;
        } else {
            return this.areaSize * 12;
        }
    }
}
