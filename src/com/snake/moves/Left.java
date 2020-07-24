package com.snake.moves;

import com.snake.Game;
import com.snake.util.Timer;

public class Left implements Movable {
    @Override
    public void move(Game game) {
        if (game.getX() != 0) {
            game.setX(game.getX() - 1);
        } else {
            game.setX(game.getAreaSize() - 1);
        }

        Timer.waitInterval(Game.TIMER);
        game.setSnakeCoordinates(game.getX(), game.getY());
        game.getPanel().highlight(game.getSnake());
        game.setKeyPressed(false);
    }
}
