package org.example;

import java.util.List;

public class DepthFirst {
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path, MazePanel panel) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        panel.repaint();

        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }

        if (maze[y][x] == 0) {
            maze[y][x] = 2;

            int[][] directions = {
                    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
            };

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (searchPath(maze, newX, newY, path, panel)) {
                    path.add(x);
                    path.add(y);
                    return true;
                }
            }
        }

        return false;
    }
}
