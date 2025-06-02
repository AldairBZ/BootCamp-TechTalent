package UD19SwingAWT;

import java.io.*;

public class EspeakTTS {
    public static void hablar(String texto) {
        try {
            ProcessBuilder pb = new ProcessBuilder("espeak", "-v", "es", "-s", "150", "-p", "50", texto);
            pb.start();
        } catch (Exception e) {
            System.out.println("Error en eSpeak TTS: " + e.getMessage());
        }
    }
}