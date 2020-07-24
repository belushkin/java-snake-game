package com.snake.moves;

import com.snake.Game;
import com.snake.util.Timer;

public class Up implements Movable{
    @Override
    public void move(Game game) {
        if (game.getY() != 0) {
            game.setY(game.getY() - 1);
        } else {
            game.setY(game.getAreaSize() - 1);
        }

        Timer.waitInterval(Game.TIMER);
        game.setSnakeCoordinates(game.getX(), game.getY());
        game.getPanel().highlight(game.getSnake());
        game.setKeyPressed(false);
    }
}
