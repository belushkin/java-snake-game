package com.snake.game;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraAdopted {

    private static class PriorityNode implements Comparable<PriorityNode> {
        private final Node node;
        private final int priority;

        public PriorityNode(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }

        public int compareTo(PriorityNode p) {
            return Integer.compare(this.priority, p.priority);
        }

        public Node getNode() {
            return node;
        }
    }

    private static class Node {
        private final int x;
        private final int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    private static class SquareGrid {
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

        private List<Node> neighbors(int x, int y) {
            List<Node> results = new ArrayList<>();

            results.add(new Node(x+1,y));
            results.add(new Node(x,y-1));
            results.add(new Node(x-1,y));
            results.add(new Node(x,y+1));

            return results.
                    stream().
                    filter(node -> inBounds(node.x, node.y)).
                    collect(Collectors.toList());
        }

        private int cost(Node from, Node to) {
            return weights.getOrDefault(to, 1);
        }
    }

    public Map<Node, Node> search(SquareGrid grid, Node start, Node goal) {

        Queue<PriorityNode> frontier = new PriorityQueue<>();

        frontier.add(new PriorityNode(start, 0));

        Map<Node, Integer> A = new HashMap<>(); // cost so far
        Map<Node, Node> B = new HashMap<>(); // came from

        // initial cost of the source is 0
        A.put(start, 0);

        // We did not come to the source from anywhere
        B.put(start, null);

        while (!frontier.isEmpty()) {
            PriorityNode currentPriorityNode = frontier.poll();
            Node current = currentPriorityNode.getNode();

            if (current.equals(goal)) {
                break;
            }

            for (Node next: grid.neighbors(current.getX(), current.getY())) {
                int newCost = A.get(current) + grid.cost(current, next);
                if (!A.containsKey(next) || newCost < A.get(next)) {
                    A.put(next, newCost);
                    frontier.add(new PriorityNode(next, newCost));
                    B.put(next, current);
                }
            }

        }
        return B;
    }

    private String drawTile(SquareGrid grid, Node node, Node start, Node goal, List<Node> path) {
        String tile = ".";

        if (node.equals(start)) {
            tile = "A";
        }
        if (node.equals(goal)) {
            tile = "Z";
        }
        if (path.contains(node)) {
            tile = "@";
        }
        return tile;
    }

    public void drawGrid(SquareGrid grid, List<Node> path, Node start, Node goal) {
        for (int y = 0; y < grid.getHeight() ; y++) {
            for (int x = 0; x < grid.getWidth() ; x++) {
                System.out.printf("%-3s", drawTile(grid, new Node(x, y), start, goal, path));
            }
            System.out.println("");
        }
    }

    public List<Node> reconstructPath(Map<Node, Node> B, Node start, Node goal) {
        Node current = goal;
        List<Node> path = new ArrayList<>();

        while (!current.equals(start)) {
            path.add(current);
            current = B.get(current);
        }
        path.add(start);
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        DijkstraAdopted dijkstra = new DijkstraAdopted();
        SquareGrid grid = new SquareGrid(10, 10);
        grid.addWeight(new Node(3,4), 5);
        grid.addWeight(new Node(3,5), 5);
        grid.addWeight(new Node(4,1), 5);
        grid.addWeight(new Node(4,2), 5);
        grid.addWeight(new Node(4,3), 5);
        grid.addWeight(new Node(4,4), 5);
        grid.addWeight(new Node(4,5), 5);
        grid.addWeight(new Node(4,6), 5);
        grid.addWeight(new Node(4,7), 5);
        grid.addWeight(new Node(4,8), 5);
        grid.addWeight(new Node(5,1), 5);
        grid.addWeight(new Node(5,2), 5);
        grid.addWeight(new Node(5,3), 5);
        grid.addWeight(new Node(5,4), 5);
        grid.addWeight(new Node(5,5), 5);
        grid.addWeight(new Node(5,6), 5);
        grid.addWeight(new Node(5,7), 5);
        grid.addWeight(new Node(5,8), 5);
        grid.addWeight(new Node(6,2), 5);
        grid.addWeight(new Node(6,3), 5);
        grid.addWeight(new Node(6,4), 5);
        grid.addWeight(new Node(6,5), 5);
        grid.addWeight(new Node(6,6), 5);
        grid.addWeight(new Node(6,7), 5);
        grid.addWeight(new Node(7,3), 5);
        grid.addWeight(new Node(7,4), 5);
        grid.addWeight(new Node(7,5), 5);

        Map<Node, Node> B = dijkstra.search(
                grid,
                new Node(1,4),
                new Node(7,8)
        );

        dijkstra.drawGrid(
                grid,
                dijkstra.reconstructPath(B, new Node(1,4), new Node(7,8)),
                new Node(1,4),
                new Node(7,8)
        );
    }
}
