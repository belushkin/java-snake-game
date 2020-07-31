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

    public void searchPath(Node start, Node goal) {
        path = reconstructPath(
                astar.search(squareGrid, start, goal),
                start,
                goal
        );
        System.out.println("start: " + start);
        System.out.println("goal: " + goal);
        System.out.println(path);
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
        if (cursor >= path.size()) {
            setPathFound(false);
            cursor = 0;
            return;
        }
//        System.out.println("cursor: " + cursor);
//        System.out.println("snake head X: " + game.getSnake().getHeadX() + " snake head Y: " + game.getSnake().getHeadY());
//        System.out.println("cursor:" + path.get(cursor));
        if (path.get(cursor).getX() < game.getSnake().getHeadX()) {
            cursor++;
            Moves.LEFT.getMove().move(game);
        } else if (path.get(cursor).getX() > game.getSnake().getHeadX()) {
            cursor++;
            Moves.RIGHT.getMove().move(game);
        } else if (path.get(cursor).getY() < game.getSnake().getHeadY()) {
            cursor++;
            Moves.UP.getMove().move(game);
        } else if (path.get(cursor).getY() > game.getSnake().getHeadY()) {
            cursor++;
            Moves.DOWN.getMove().move(game);
        }
    }

}
