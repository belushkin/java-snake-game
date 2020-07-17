package com.snake.gui;

import javax.swing.*;
import java.awt.*;

public class Panel {
    private final JPanel jPanel;
    private final Color bgColor = Color.BLACK;
    private final Color snColor = Color.CYAN;
    private final Color foodColor = Color.MAGENTA;

    public Panel(JPanel jPanel) {
        this.jPanel = jPanel;
        this.jPanel.setBackground(bgColor);
    }

    public JPanel getjPanel() {
        return jPanel;
    }


}
