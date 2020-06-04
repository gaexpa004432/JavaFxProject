package media_pack;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaController implements Initializable {
	@FXML
	ImageView imageView;
	@FXML
	MediaView mediaView;
	@FXML
	Button btnPlay, btnPause, btnStop;
	@FXML
	Label labelTime;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Media media = new Media(getClass().getResource("/media_pack/video.mp4").toString());
		MediaPlayer player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
//////////////////////////////////////////////////////////////////
		btnPlay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent a) {
				player.play();
			}
		});
		btnStop.setOnAction((a) -> player.stop());
		btnPause.setOnAction((a) -> player.pause());
////////////////////////////////////////////////////////////////////
		player.setOnReady(new Runnable() {

			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
			}
		});
		player.setOnStopped(new Runnable() {

			@Override
			public void run() {
				btnPlay.setDisable(false);
				btnStop.setDisable(true);
				btnPause.setDisable(true);
			}
		});
		player.setOnPlaying(new Runnable() {

			@Override
			public void run() {
				btnPlay.setDisable(true);
				btnStop.setDisable(false);
				btnPause.setDisable(false);
			}
		});

		player.setOnPaused(new Runnable() {

			@Override
			public void run() {
				btnPause.setDisable(true);
				btnStop.setDisable(false);
				btnPlay.setDisable(false);
			}
		});
		player.setOnEndOfMedia(new Runnable() {

			@Override
			public void run() {
				btnPause.setDisable(true);
				btnStop.setDisable(true);
				btnPlay.setDisable(false);
				player.stop();
			}});
	}

}
