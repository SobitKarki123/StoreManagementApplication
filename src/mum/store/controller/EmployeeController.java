package mum.store.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import mum.store.bal.DialogHelper;
import mum.store.bal.EmployeeManager;
import mum.store.model.Employee;

public class EmployeeController implements Initializable {
	@FXML
	private TextField empNameTextField;
	@FXML
	private TextField empAddressTextField;
	@FXML
	private TextField empEmailTextField;
	@FXML
	private TextField empUserNameTextField;
	@FXML
	private PasswordField empPasswordTextField;
	@FXML
	private ComboBox<String> empRoleComboField;

	public EmployeeController() {

	}

	private Stage dialogStage;
	private Employee employee;
	private ObservableList<String> roleItems;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	private void handleClear() {
		empNameTextField.setText("");
		empAddressTextField.setText("");
		empEmailTextField.setText("");
		empUserNameTextField.setText("");
		empPasswordTextField.setText("");
		empRoleComboField.setValue(roleItems.get(0));
	}

	@FXML
	private void handleSave() {
		employee = new Employee(empNameTextField.getText(), empAddressTextField.getText(),
				empEmailTextField.getText(), empUserNameTextField.getText(),
				empPasswordTextField.getText(), empRoleComboField.getSelectionModel().getSelectedIndex());

		EmployeeManager empManager = new EmployeeManager();
		boolean status = empManager.insertEmployee(employee);
		if (status){
			DialogHelper.showAlertDialog("Employee Added Successfully", AlertType.INFORMATION);
		}
		else {
			DialogHelper.showAlertDialog("Failed to Save", AlertType.ERROR);
		}
		dialogStage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		roleItems = FXCollections.observableArrayList("Cashier", "Store Manager");
		empRoleComboField.getItems().addAll(roleItems);
		empRoleComboField.setValue(roleItems.get(0));
	}
}
