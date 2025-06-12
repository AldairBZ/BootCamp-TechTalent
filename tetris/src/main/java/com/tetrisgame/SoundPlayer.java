package com.tetrisgame;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {
    private Clip clip;

    public void playMusic(String filePath, boolean loop, float volume) {
        try {
            URL soundURL = getClass().getResource(filePath);
            if (soundURL == null) {
                System.err.println("Archivo de sonido no encontrado: " + filePath);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Control de volumen
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log10(volume) * 20);  // volumen debe ser entre 0.0 y 1.0
            gainControl.setValue(dB);

            clip.start();
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    public void playEffect(String filePath) {
        try {
            URL soundURL = getClass().getResource(filePath);
            if (soundURL == null) {
                System.err.println("Efecto no encontrado: " + filePath);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
            Clip effectClip = AudioSystem.getClip();
            effectClip.open(audioStream);
            effectClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
