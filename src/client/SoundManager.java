package client;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class SoundManager {

    private static SoundManager instance = null;
    private MediaPlayer bgMusicPlayer;
    private MediaPlayer clickSoundPlayer;

    private SoundManager() {
        String pathSound = "/src/Audio/bgm 2.mp3"; // Replace with your background music file path
        String pathClick = "/src/Audio/click.wav"; // Replace with your click sound file path
        String directorySound = System.getProperty("user.dir");
        String bgMusicFile = directorySound + pathSound;
        String clickSoundFile = directorySound + pathClick;

        Media bgMusicMedia = new Media(new File(bgMusicFile).toURI().toString());
        Media clickSoundMedia = new Media(new File(clickSoundFile).toURI().toString());

        bgMusicPlayer = new MediaPlayer(bgMusicMedia);
        clickSoundPlayer = new MediaPlayer(clickSoundMedia);

        bgMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public static SoundManager getInstance() {
        if (instance == null) {
            instance = new SoundManager();
        }
        return instance;
    }

    public void playBackgroundMusic() {
        bgMusicPlayer.play();
    }

    public void stopBackgroundMusic() {
        bgMusicPlayer.stop();
    }

    public void playClickSound() {
        clickSoundPlayer.play();
    }

    public void stopClickSound() {
        clickSoundPlayer.stop();
    }
}
