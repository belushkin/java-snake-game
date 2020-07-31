package com.snake.ai;

public class PriorityNode implements Comparable<PriorityNode> {
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
