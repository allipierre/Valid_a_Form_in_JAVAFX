package application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MainApp extends Application {
	BorderPane root;
	Stage primaryStage;
	

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
    	this.primaryStage = stage;
    	initRootLayout();
        
        showA1();
    }

    public void showA1() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("A1.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			root.setCenter(personOverview);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    @FXML
    public void initRootLayout() {
		root = new BorderPane();

	       // Label label = new Label();
	       // Label label1 = new Label();
	        //root.getChildren().add(label1);
	        try {
	        	 ConfigurationBuilder cb= new ConfigurationBuilder();
	        	  cb.setDebugEnabled(true)
	        	  .setOAuthConsumerKey("ThDD6X2RjqUIPnPp0I2XTSNrm")
	        	    .setOAuthConsumerSecret("esyB9VE4Gp2yDOEJhzZP615r2w0gIti3spgctH79v0pyyU2QQN")
	        	    .setOAuth2AccessToken("1086623130-6EojcnKazCdBT7NohaZ62PwBJveNUUjD3qPLXpF")
	        	    .setOAuthAccessTokenSecret("m2mcjaPvjl2wEi37VzxkHpG6sKLvQhaOVIMM1F07num8S")
	        	    ;
	        	TwitterFactory tf= new TwitterFactory(cb.build()); //configurations
	            Twitter twitter= tf.getInstance();
	            ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
	           // IDL.setText(homeTimeline.get(0).getText());
	            //label1.setText(homeTimeline.get(1).getText());
	        } catch (TwitterException ex) {
	            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
	        }
	       
	        primaryStage.setTitle("Tweetalot");

		Scene scene = new Scene(root, 1024, 728);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
