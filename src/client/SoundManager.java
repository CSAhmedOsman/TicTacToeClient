package client;

import java.io.File;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundManager {

    private static String directory;
    private static String path;
    private static String fileName;
    private static Media media;
    private static MediaPlayer mediaPlayer;

    public SoundManager() {
        fileName = "/src/Audio/bgm2.mp3";
        directory = System.getProperty("user.dir");
        path = directory + fileName;
        media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void playSound() {
        mediaPlayer.play();
    }

    public void stopSound() {
        mediaPlayer.stop();
    }
}
