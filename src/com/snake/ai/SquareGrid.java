package com.snake.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SquareGrid {
    private final int width;
    private final int height;
    private final Map<Node, Integer> weights = new HashMap<>();

    public SquareGrid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addWeight(Node node, int weight) {
        weights.put(node, weight);
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

    public List<Node> neighbors(int x, int y) {
        List<Node> results = new ArrayList<>();

        results.add(new Node(x+1,y));
        results.add(new Node(x,y-1));
        results.add(new Node(x-1,y));
        results.add(new Node(x,y+1));

        return results.
                stream().
                filter(node -> inBounds(node.getX(), node.getY())).
                collect(Collectors.toList());
    }

    public int cost(Node from, Node to) {
        return weights.getOrDefault(to, 1);
    }
}
