package com.snake;

import com.snake.ai.Astar;
import com.snake.ai.Node;
import com.snake.ai.SquareGrid;

import java.util.Map;

public class Ai {

    private final static int SNAKE_WEIGHT = 5;

    private boolean pathFound;
    private final int areaSize;
    private Snake snake;
    private SquareGrid squareGrid;

    public Ai(int areaSize) {
        this.areaSize = areaSize;
    }

    public void setSnakeWeights(Snake snake) {
        squareGrid = new SquareGrid(areaSize, areaSize);

        for (int i = 0; i < snake.getLength(); i++) {
            squareGrid.addWeight(new Node(snake.getX(i), snake.getY(i)), SNAKE_WEIGHT);
        }
    }

    public void searchPath() {
        Astar astar = new Astar();
        Map<Node, Node> path = astar.search(
                squareGrid,
                new Node(1,4),
                new Node(7,8)
        );

    }

    public boolean isPathFound() {
        return pathFound;
    }

    public void setPathFound(boolean pathFound) {
        this.pathFound = pathFound;
    }
}
