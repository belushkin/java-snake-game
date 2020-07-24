package com.snake.moves;

public enum Moves {
    UP("UP", new Up()),
    DOWN("DOWN", new Down()),
    LEFT("LEFT", new Left()),
    RIGHT("RIGHT", new Right()),
    AUTO("AUTO", new Auto());

    private final String key;
    private final Movable move;

    Moves(String key, Movable move) {
        this.key = key;
        this.move = move;
    }

    public String getKey() {
        return key;
    }

    public Movable getMove() {
        return move;
    }
}
