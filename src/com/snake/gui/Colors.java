package com.snake.gui;

import java.awt.*;

public enum Colors {
    BG_COLOR(Color.BLACK),
    SNAKE_COLOR(Color.CYAN),
    FOOD_COLOR(Color.MAGENTA),
    GRAY_COLOR(Color.DARK_GRAY);

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
