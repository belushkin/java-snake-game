package com.snake.ai;

import java.util.*;
import java.util.stream.Collectors;

public class SquareGrid {
    private final int width;
    private final int height;
    private final Map<Node, Integer> weights = new HashMap<>();
    private final Set<Node> walls = new HashSet<>();

    public SquareGrid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addWeight(Node node, int weight) {
        weights.put(node, weight);
    }

    public void addWall(Node node) {
        walls.add(node);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private boolean passable(Node node) {
        return !walls.contains(node);
    }

    public List<Node> neighbors(int x, int y) {
        List<Node> results = new ArrayList<>();

        results.add(new Node(x+1,y));
        results.add(new Node(x,y-1));
        results.add(new Node(x-1,y));
        results.add(new Node(x,y+1));

        return results.
                stream().
                filter(node -> inBounds(node.getX(), node.getY())).
                filter(this::passable).
                collect(Collectors.toList());
    }

    public int cost(Node from, Node to) {
        return weights.getOrDefault(to, 1);
    }
}
