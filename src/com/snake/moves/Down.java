package com.snake.moves;

import com.snake.Game;
import com.snake.util.Timer;

public class Down implements Movable {
    @Override
    public void move(Game game) {
        if (game.getY() != game.getAreaSize() - 1) {
            game.setY(game.getY() + 1);
        } else {
            game.setY(0);
        }

        Timer.waitInterval(Game.TIMER);
        game.getPanel().highlight(game.getSnake());
        game.setSnakeCoordinates(game.getX(), game.getY());
        game.setKeyPressed(false);
    }
}
