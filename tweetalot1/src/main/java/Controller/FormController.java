/**
 * 
 */
package Controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import application.MainApp;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author yotti
 *
 */
public class FormController implements Initializable {

	@FXML
	TextField firstName;
	@FXML
	TextField lastName;
	@FXML
	CheckBox javaFx;
	@FXML
	CheckBox performanceTuning;
	@FXML
	CheckBox javaSpecialistMaster;
	@FXML
	Button saveButton;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText("I have a great message for you!");

		alert.showAndWait();
	}

	public void initialize(java.net.URL location, ResourceBundle resources) {
		BooleanBinding nameEntered = firstName.textProperty().isNotEmpty()
				.and(firstName.textProperty().length().greaterThan(2)).and(lastName.textProperty().isNotEmpty())
				.and(lastName.textProperty().length().greaterThan(2)).and(firstName.textProperty().isEqualTo("pierre"));

		BooleanBinding courseSelected = performanceTuning.selectedProperty()
				.or(javaFx.selectedProperty().or(javaSpecialistMaster.selectedProperty()));
		saveButton.disableProperty().bind(courseSelected.and(nameEntered).not());

	}
	public  void start() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("A2.fxml"));
         Parent root1 = null;
		try {
			root1 = (Parent) fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Stage stage = new Stage();
         stage.initModality(Modality.APPLICATION_MODAL);
        
         stage.setTitle("ABC");
         stage.setScene(new Scene(root1));  
         stage.show();
        
       
    }

}