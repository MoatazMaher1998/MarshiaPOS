package Marshia;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class mainmarshia extends Application{
	public static MediaPlayer mediaPlayer1;
	private Stage PrimaryStage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.PrimaryStage=primaryStage;
		showPrimaryPage();
	
		
	}
	public void showPrimaryPage() throws IOException {
		Parent mainViewRoot =  FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		Scene scene = new Scene(mainViewRoot);
		PrimaryStage.setScene(scene);
		PrimaryStage.setTitle("Marshia's Warehouse");
		PrimaryStage.getIcons().add(new Image("M.jpg"));
		PrimaryStage.setMaximized(true);
		PrimaryStage.show();
	}
	public static void main(String[] args) {
		
		launch(args);
	}

   @SuppressWarnings("unused")
private void playmusic() {
	   String musicFile = "B.mp3";     // For example
		Media sound = new Media(new File(musicFile).toURI().toString());
	    mediaPlayer1 = new MediaPlayer(sound);
		mediaPlayer1.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer1.play();
   }
 
}


