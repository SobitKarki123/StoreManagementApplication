package mum.store.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import mum.store.bal.DialogHelper;
import mum.store.bal.LoginManager;
import mum.store.bal.LoginRecordhelper;

public class PasswordController implements Initializable {

	@FXML
	private PasswordField oldPassword;
	@FXML
	private PasswordField newPassword;

	private Stage dialogStage;

	@FXML
	private void initialize() {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void clearItem() {
		newPassword.setText("");
	}

	@FXML
	public void changePassword() {
		LoginManager manager = new LoginManager();
		if (manager.changePassword(oldPassword.getText(), newPassword.getText())) {
			DialogHelper.showAlertDialog("Password Changed Successfully", AlertType.INFORMATION);
		} else {
			DialogHelper.showAlertDialog("Error changing password", AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		oldPassword.setText(LoginRecordhelper.getPassword());
	}
}
