package com.snake.game;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private int areaSize = 34;
    private JFrame frame;
    private JLabel[][] screen;
    private JPanel gamepanel;
    private int x, y;
    private final Color bgColor = Color.BLACK;
    private final Color snColor = Color.CYAN;
    private final Color foodColor = Color.MAGENTA;

    public void init(int areaSize) {
        this.areaSize = areaSize;

        frame = new JFrame();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamepanel = new JPanel(new GridLayout(areaSize, areaSize));
        gamepanel.setBackground(bgColor);

        frame.setContentPane(gamepanel);
        screen = new JLabel[areaSize][areaSize];

        this.x = 0;
        this.y = 0;
        while (y < areaSize - 1) {
            screen[this.x][this.y] = new JLabel();
            screen[this.x][this.y].setText("■");
            gamepanel.add(screen[x][y]);
            this.x++;
            if (this.x == areaSize - 1 && this.y < areaSize - 1) {
                this.x = 0;
                this.y++;
            }
        }
        frame.setSize(getFrameSize(), getFrameSize());
        frame.setResizable(false);
    }

    public int getFrameSize() {
        if (this.areaSize > 29) {
            return this.areaSize * 11;
        } else {
            return this.areaSize * 12;
        }
    }

}
