package mum.store.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import mum.store.bal.DialogHelper;
import mum.store.bal.ProductManager;
import mum.store.model.Product;
import mum.store.repository.ProductRepository;

public class ProductController {
	@FXML
	private TextField itemNameTextField;
	@FXML
	private TextField itemCodeTextField;
	@FXML
	private TextField itemPriceTextField;
	@FXML
	private TextField itemIdTextField;

	private Stage dialogStage;
	private Product product;

	public ProductController() {

	}

	@FXML
	private void initialize() {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	// use this in case of update
	// public void setProduct(Product product) {
	// if (product != null) {
	// this.product = product;
	// itemNameTextField.setText(product.getItemName());
	// itemCodeTextField.setText(product.getItemCode());
	// itemPriceTextField.setText(product.getPrice().toString());
	// itemIdTextField.setText(product.getItemId().toString());
	// }
	// }

	// public boolean isBtnClicked() {
	// return btnClicked;
	// }

	@FXML
	private void handleClear() {
		// dialogStage.close();
		itemNameTextField.setText("");
		itemCodeTextField.setText("");
		itemPriceTextField.setText("");
	}

	@FXML
	private void handleSave() {
		Product product = new Product(itemNameTextField.getText(), itemCodeTextField.getText(),
				Double.parseDouble(itemPriceTextField.getText()), Long.parseLong("1"));
		ProductManager productManager = new ProductManager();
		boolean status = productManager.insertProduct(product);
		if (status) {
			DialogHelper.showAlertDialog("Saved Successfully", AlertType.INFORMATION);
		} else {
			DialogHelper.showAlertDialog("Failed to Save", AlertType.ERROR);
		}
		dialogStage.close();
	}



}
