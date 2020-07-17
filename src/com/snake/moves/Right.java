package com.snake.moves;

public class Right implements Movable{
    public void move() {
        //movedir="RIGHT";
        if (this.x != areaSize - 2) {
            this.x++;
        } else {
            this.x = 0;
        }
        waitInterval(TIMER);
        updatePosition();
        game.setCoord(x, y);
        mvlock = false;
    }
}
