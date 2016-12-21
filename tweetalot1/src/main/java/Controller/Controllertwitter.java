/**
 * 
 */
package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @author yotti
 *
 */
public class Controllertwitter {
	@FXML
	private  Label IDL;
	@FXML
	private  Label IDL1;
	@FXML
	private  Label IDL3;
	@FXML
	private  Label IDL4;

	public Controllertwitter() {

	}

	@FXML
	private void initialize() {
		showA1();
		
	}

	public  void showA1()  {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("ThDD6X2RjqUIPnPp0I2XTSNrm")
					.setOAuthConsumerSecret("esyB9VE4Gp2yDOEJhzZP615r2w0gIti3spgctH79v0pyyU2QQN")
					.setOAuth2AccessToken("1086623130-6EojcnKazCdBT7NohaZ62PwBJveNUUjD3qPLXpF")
					.setOAuthAccessTokenSecret("m2mcjaPvjl2wEi37VzxkHpG6sKLvQhaOVIMM1F07num8S");
			TwitterFactory tf = new TwitterFactory(cb.build()); // configurations
			Twitter twitter = tf.getInstance();
			ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
			IDL.setText(homeTimeline.get(0).getText());
			IDL1.setText(homeTimeline.get(1).getText());
			IDL3.setText(homeTimeline.get(2).getText());
			IDL4.setText(homeTimeline.get(3).getText());

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("A1.fxml"));
			//AnchorPane personOverview = (AnchorPane) loader.load();

		

		} catch (TwitterException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	@FXML
	   private void handleButtonAction() {
		new FormController().start();
	   }

}
