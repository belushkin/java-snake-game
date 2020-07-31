package com.snake.ai;

import java.util.*;

public class Astar {

    private int heuristic(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
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
                    int priority = newCost + heuristic(goal, next);
                    frontier.add(new PriorityNode(next, priority));
                    B.put(next, current);
                }
            }

        }
        return B;
    }
}
