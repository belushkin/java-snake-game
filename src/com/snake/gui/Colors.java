package com.snake.gui;

import java.awt.*;

public enum Colors {
    BG_COLOR(Color.BLACK),
    SNAKE_COLOR(Color.CYAN),
    FOOD_COLOR(Color.MAGENTA);

    private Color color;

    Colors(Color color) {
        this.color = color;
    }
}
