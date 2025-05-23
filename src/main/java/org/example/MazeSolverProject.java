package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MazeSolverProject extends JFrame {
    private final int[][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,0,0,1,0,0,0,1},
            {1,0,1,0,1,0,1,1,0,1,0,1},
            {1,0,1,0,0,0,0,1,0,1,0,1},
            {1,0,1,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,1,0,1,0,0,0,1},
            {1,1,1,1,0,1,0,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,1,1,1,1,1,0,1,0,1},
            {1,0,0,0,0,0,0,1,0,0,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1}
    };

    private final List<Integer> path = new ArrayList<>();
    private final MazePanel mazePanel = new MazePanel(maze, path);

    public MazeSolverProject() {
        setTitle("Maze Solver (No Flicker)");
        setSize(640, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(mazePanel);
        setVisible(true);

        // Start DFS in separate thread to avoid blocking GUI
        new Thread(() -> DepthFirst.searchPath(maze, 1, 1, path, mazePanel)).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MazeSolverProject::new);
    }
}
