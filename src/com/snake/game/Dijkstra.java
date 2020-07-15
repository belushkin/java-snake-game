package com.snake.game;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

    class VertexComparator implements Comparator<Vertex> {
        public int compare(Vertex v1, Vertex v2) {
            if (v1.value > v2.value)
                return 1;
            else if (v1.value < v2.value)
                return -1;
            return 0;
        }
    }

    class Vertex {
        public int[] coord;
        public int value;

        public Vertex(int[] coord, int value) {
            this.coord = coord;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();

        int[][] grid = {
                {1, 4, 3, 2},
                {5, 3, 5, 1},
                {1, 4, 5, 2},
                {1, 4, 5, 2}
        };

        System.out.println(Arrays.deepToString(dijkstra.minPathSum(grid)));
    }

    public int[][] minPathSum(int[][] grid) {
        Queue<Vertex> pq = new
                PriorityQueue<>(
                grid.length*grid[0].length,
                new VertexComparator()
        );

        int[][] dirs    = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int[][] A       = new int[grid.length][grid[0].length];

        // Initialization
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                A[i][j] = (i == 0 && j == 0) ? grid[i][j] : Integer.MAX_VALUE;
                pq.add(new Vertex(new int[]{i,j}, A[i][j]));
            }
        }

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            int y = v.coord[0];
            int x = v.coord[1];

            for (int[] dir: dirs) {
//                System.out.println((x + dir[1]) + " " + (y + dir[0]) + " " + v.value);
                if (x + dir[1] >= 0 && x + dir[1] < grid[0].length && y + dir[0] >= 0 && y + dir[0] < grid.length) {
                    int new_y = y + dir[0];
                    int new_x = x + dir[1];

//                    System.out.println(grid[new_y][new_x] + " " + v.value);

                    if (A[new_y][new_x] > (A[y][x] + grid[new_y][new_x])) {
                        A[new_y][new_x] = A[y][x] + grid[new_y][new_x];
                        pq.add(new Vertex(new int[]{new_y,new_x}, A[new_y][new_x]));
                    }
                }
            }
        }
        return A; // A[grid.length-1][grid[0].length-1]
    }

}
