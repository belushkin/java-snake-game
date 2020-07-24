package com.snake.moves;

public enum Moves {
    UP("UP"),
    DOWN("DOWN"),
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    AUTO("AUTO");

    private final String move;

    Moves(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }
}
