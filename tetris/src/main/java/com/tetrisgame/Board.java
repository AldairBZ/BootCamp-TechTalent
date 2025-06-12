package com.tetrisgame;

import java.awt.*;

public class Board {
    private final int width, height;
    private final Color[][] grid;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Color[height][width];
    }

    public boolean isValidPosition(Tetromino tetromino, int x, int y) {
        for (Point p : tetromino.getBlocks()) {
            int newX = x + p.x;
            int newY = y + p.y;
            if (newX < 0 || newX >= width || newY < 0 || newY >= height) return false;
            if (grid[newY][newX] != null) return false;
        }
        return true;
    }

    public void placeTetromino(Tetromino tetromino, int x, int y) {
        for (Point p : tetromino.getBlocks()) {
            grid[y + p.y][x + p.x] = tetromino.getColor();
        }
    }

    public int clearLines() {
        int linesCleared = 0;
        for (int row = 0; row < height; row++) {
            boolean full = true;
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == null) {
                    full = false;
                    break;
                }
            }
            if (full) {
                linesCleared++;
                for (int r = row; r > 0; r--) {
                    grid[r] = grid[r - 1];
                }
                grid[0] = new Color[width];
            }
        }
        return linesCleared;
    }

    public void draw(Graphics g, int tileSize) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (grid[row][col] != null) {
                    g.setColor(grid[row][col]);
                    g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(col * tileSize, row * tileSize, tileSize, tileSize);
                }
            }
        }
    }
}

