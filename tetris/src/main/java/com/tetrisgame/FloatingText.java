// Clase FloatingText.java
package com.tetrisgame;

import java.awt.*;
import java.util.ArrayList;



public class FloatingText {
    private String text;
    private int x, y;
    private int alpha = 255;

    public FloatingText(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }
    public boolean update() {
        y -= 4;
        alpha -= 30;
        return alpha > 0;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 0, alpha));
        g.setFont(g.getFont().deriveFont(Font.BOLD, 18f));
        g.drawString(text, x, y);
    }
}
