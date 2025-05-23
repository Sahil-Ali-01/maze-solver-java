package org.example;

import javax.swing.JPanel;
import java.awt.*;
import java.util.List;

public class MazePanel extends JPanel {
    private final int[][] maze;
    private final List<Integer> path;

    public MazePanel(int[][] maze, List<Integer> path) {
        this.maze = maze;
        this.path = path;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 30;
        int mazeWidth = maze[0].length * cellSize;
        int mazeHeight = maze.length * cellSize;

        int offsetX = (getWidth() - mazeWidth) / 2;
        int offsetY = (getHeight() - mazeHeight) / 2;

        g.translate(offsetX, offsetY);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1 -> color = Color.BLACK;
                    case 9 -> color = Color.RED;
                    case 2 -> color = Color.blue;
                    default -> color = Color.WHITE;
                }

                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                g.setColor(Color.GRAY);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }

        for (int i = 0; i < path.size(); i += 2) {
            int x = path.get(i);
            int y = path.get(i + 1);
            g.setColor(Color.GREEN);
            g.fillRect(30 * x, 30 * y, 30, 30);
        }
    }
}
