package com.tetrisgame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tetris");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(new GamePanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        SoundPlayer player = new SoundPlayer();
        player.playMusic("/sounds/TetrisTheme.wav", true, 0.3f);  // volumen: 30%


    }
}