
package com.tetrisgame;

import java.awt.*;

public class Tetromino {
    public enum Type { I, O, T, S, Z, J, L }

    private Point[] blocks;
    private Color color;
    private Type type;
    private int rotation;

    public Tetromino(Type type) {
        this.type = type;
        this.rotation = 0;
        generateShape();

        // Verificación defensiva
        if (blocks == null) {
            throw new IllegalStateException("Tetromino blocks not initialized for type: " + type);
        }
    }

    private void generateShape() {
        switch (type) {
            case O -> {
                blocks = new Point[]{new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)};
                color = Color.YELLOW;
            }
            case I -> {
                blocks = new Point[]{new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(2, 0)};
                color = Color.CYAN;
            }
            case T -> {
                blocks = new Point[]{new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(0, 1)};
                color = Color.MAGENTA;
            }
            case S -> {
                blocks = new Point[]{new Point(0, 0), new Point(1, 0), new Point(-1, 1), new Point(0, 1)};
                color = Color.GREEN;
            }
            case Z -> {
                blocks = new Point[]{new Point(-1, 0), new Point(0, 0), new Point(0, 1), new Point(1, 1)};
                color = Color.RED;
            }
            case J -> {
                blocks = new Point[]{new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(1, 1)};
                color = Color.BLUE;
            }
            case L -> {
                blocks = new Point[]{new Point(-1, 0), new Point(0, 0), new Point(1, 0), new Point(-1, 1)};
                color = Color.ORANGE;
            }
        }
    }

    public Point[] getBlocks() {
        return blocks;
    }

    public Color getColor() {
        return color;
    }

    public void rotateClockwise() {
        for (Point p : blocks) {
            int x = p.x, y = p.y;
            p.x = -y;
            p.y = x;
        }
        rotation = (rotation + 1) % 4;
    }

    public Tetromino copy() {
        Tetromino copy = new Tetromino(this.type);
        copy.rotation = this.rotation;
        copy.blocks = new Point[blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            copy.blocks[i] = new Point(blocks[i]);
        }
        return copy;
    }

    public Type getType() {
        return type;
    }
}