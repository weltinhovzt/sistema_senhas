/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senha.control;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author gustavosmc
 */
public class MediaHelper {
    public static boolean repeat;
    private static MediaPlayer videoPlayer;
    private static AudioClip musicPlayer;
    
    public static void initSom(final String media){
            showSom(media);
    }

    public static void initVideo(final JFXPanel fxPanel,final Media media) {
        // This method is invoked on the EDT thread

        Platform.runLater(() -> {
            initFX(fxPanel,media);
        });
    }

    private static void initFX(final JFXPanel fxPanel, Media media) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene(media);
        fxPanel.removeAll();
        fxPanel.setScene(scene);
    }

    private static Scene createScene(Media media) {
        Group root = new Group();
        Scene scene = new Scene(root);
        videoPlayer = new MediaPlayer(media);
        MediaView mv = new MediaView(videoPlayer);
        root.getChildren().add(mv);
        root.autoSizeChildrenProperty();
        root.setAutoSizeChildren(true);
        mv.fitHeightProperty().set(940);
        mv.fitWidthProperty().set(940);
        mv.smoothProperty().set(true);
        videoPlayer.muteProperty().set(true);
        
        videoPlayer.cycleCountProperty().set(10000000);

        videoPlayer.play();

        return (scene);
    }

    private static void showSom(String media) {
        musicPlayer = new AudioClip(media);
        musicPlayer.play();
    
    }
}
