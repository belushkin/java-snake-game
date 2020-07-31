package com.snake;

import com.snake.ai.Astar;
import com.snake.ai.Node;
import com.snake.ai.SquareGrid;
import com.snake.moves.Moves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Ai {

    private final static int SNAKE_WEIGHT = 5;

    private boolean pathFound;
    private SquareGrid squareGrid;
    private List<Node> path;
    private int cursor = 0;

    private final Game game;
    private final Astar astar = new Astar();

    public Ai(Game game) {
        this.game = game;
    }

    public void setSnakeWeights(Snake snake) {
        squareGrid = new SquareGrid(game.getAreaSize(), game.getAreaSize());

        for (int i = 0; i < snake.getLength(); i++) {
            squareGrid.addWeight(
                    new Node(snake.getX(i), snake.getY(i)),
                    SNAKE_WEIGHT
            );
        }
    }

    public void setSnakeWalls(Snake snake) {
        squareGrid = new SquareGrid(game.getAreaSize(), game.getAreaSize());

        for (int i = 0; i < snake.getLength(); i++) {
            squareGrid.addWall(
                    new Node(snake.getX(i), snake.getY(i))
            );
        }
    }

    public void searchPath(Node start, Node goal) {
        path = reconstructPath(
                astar.search(squareGrid, start, goal),
                start,
                goal
        );
    }

    public boolean isPathFound() {
        return pathFound;
    }

    public void setPathFound(boolean pathFound) {
        this.pathFound = pathFound;
    }

    public List<Node> reconstructPath(Map<Node, Node> B, Node start, Node goal) {
        Node current = goal;
        List<Node> path = new ArrayList<>();

        while (!current.equals(start)) {
            path.add(current);
            current = B.get(current);
        }
//        path.add(start);
        Collections.reverse(path);

        return path;
    }

    public void traversePath() {
        if (path.get(cursor).getX() < game.getSnake().getHeadX()) {
            cursor++;
            checkCursor();
            game.setDirection(Moves.LEFT.getKey());
        } else if (path.get(cursor).getX() > game.getSnake().getHeadX()) {
            cursor++;
            checkCursor();
            game.setDirection(Moves.RIGHT.getKey());
        } else if (path.get(cursor).getY() < game.getSnake().getHeadY()) {
            cursor++;
            checkCursor();
            game.setDirection(Moves.UP.getKey());
        } else if (path.get(cursor).getY() > game.getSnake().getHeadY()) {
            cursor++;
            checkCursor();
            game.setDirection(Moves.DOWN.getKey());
        }
    }

    private void checkCursor() {
        if (cursor >= path.size()) {
            setPathFound(false);
            cursor = 0;
        }
    }

}
