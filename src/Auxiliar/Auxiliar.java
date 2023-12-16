package Auxiliar;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Auxiliar {
public static boolean admin=false;
public static boolean login= false;
public static boolean firstLogin=true;

public static void reproducirSonido() {
    try {
        // Obtener la URL del archivo de sonido
    	String archivoSonido="src/Sonido/button-pressed-38129.wav";
        File file = new File(archivoSonido);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());

        // Obtener el clip de audio
        Clip clip = AudioSystem.getClip();

        // Abrir el flujo de audio y reproducir
        clip.open(audioIn);
        clip.start();
    } catch (UnsupportedAudioFileException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    } catch (LineUnavailableException ex) {
        ex.printStackTrace();
    }
}

public static void reproducirSonidoError() {
    try {
        // Obtener la URL del archivo de sonido
    	String archivoSonido="src/Sonido/error-126627.wav";
        File file = new File(archivoSonido);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());

        // Obtener el clip de audio
        Clip clip = AudioSystem.getClip();

        // Abrir el flujo de audio y reproducir
        clip.open(audioIn);
        clip.start();
    } catch (UnsupportedAudioFileException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    } catch (LineUnavailableException ex) {
        ex.printStackTrace();
    }
}

public static void reproducirSonidoBoton() {
    try {
        // Obtener la URL del archivo de sonido
    	String archivoSonido="src/Sonido/radio-switch-83014 (mp3cut.net) (1).wav";
        File file = new File(archivoSonido);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());

        // Obtener el clip de audio
        Clip clip = AudioSystem.getClip();

        // Abrir el flujo de audio y reproducir
        clip.open(audioIn);
        clip.start();
    } catch (UnsupportedAudioFileException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    } catch (LineUnavailableException ex) {
        ex.printStackTrace();
    }
}
}
