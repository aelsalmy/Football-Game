/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Controller;

/**
 *
 * @author abdul
 */
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

    private static Clip clip;
    private static File f;



    public static void GoatCeleb() {
        play("goat");
    }

    public static void BellinghamCeleb() {
        play("belligoal");
    }

    public static void NunezCeleb() {
        play("darwin");
    }
    public static void Champions() {
        playLoop("champions");

    }
    public static void Ambient() {
        playLoop("ambient");

    }
    private static void playLoop(String s) {
        f = new File("resources/sounds/" + s + ".wav");

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception E) {
            System.out.println("a7a");
        }
        clip.start();
        loop();
    }

    private static void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    private static void play(String s) {
        f = new File("resources/sounds/" + s + ".wav");

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception E) {
            System.out.println("a7a");
        }
        clip.start();

    }

    public static void stop() {
        clip.stop();
    }

}
