package mum.store.bal;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogHelper {
	
	public static void showAlertDialog(String message, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(message);
		alert.showAndWait();
	}
}
