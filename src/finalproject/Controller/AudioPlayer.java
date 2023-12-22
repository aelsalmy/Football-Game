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



    public static void goatCeleb() {
        play("goat");
    }

    public static void bellinghamCeleb() {
        play("belligoal");
    }

    public static void nunezCeleb() {
        play("darwin");
    }
    public static void champions() {
        playLoop("champions");

    }
    public static void ambient() {
        playLoop("ambient");

    }
    public static void finalWhistle()
    {
        play("finalwhistle");
    }
    public static void normalWhistle()
    {
        play("whistle");
        
    }
    private static void playLoop(String s) {
        play(s);
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
            System.out.println("Audio Exception");
        }
        clip.start();

    }

    public static void stop() {
        clip.stop();
    }

}