package mum.store.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mum.store.model.PurchaseDetail;
import mum.store.MainLoginApplication;
import mum.store.controller.*;

public class MainAppController {
	
	private Stage dialogStage;
	
	@FXML
	private Menu purchaseMenu;
	
	@FXML
	private Menu employeeMenu;
	
	public Menu getPurchaseMenu() {
		return purchaseMenu;
	}
	
	public Menu getEmployeeMenu() {
		return employeeMenu;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
    public Stage getDialogStage() {
		return dialogStage;
	}

	@FXML
	public void handleNewProduct() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApplication.class.getResource("view/Product.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Product");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getDialogStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			ProductController productController = loader.getController();
			productController.setDialogStage(dialogStage);
			// setProduct(tempProduct);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleNewEmployee() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApplication.class.getResource("view/Employee.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Employee");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getDialogStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			EmployeeController employeeController = loader.getController();
			employeeController.setDialogStage(dialogStage);
			// setProduct(tempProduct);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleNewPurchase() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApplication.class.getResource("view/Purchase.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Purchase");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getDialogStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			PurchaseController purchaseController = loader.getController();
			purchaseController.setDialogStage(dialogStage);
			// setProduct(tempProduct);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleNewSale() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApplication.class.getResource("view/Sale.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Sale");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getDialogStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			SaleController saleController = loader.getController();
			saleController.setDialogStage(dialogStage);
			// setProduct(tempProduct);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleNewChangePassword() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainLoginApplication.class.getResource("view/ChangePassword.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Change Password");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(getDialogStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			PasswordController passwordController = loader.getController();
			passwordController.setDialogStage(dialogStage);
			// setProduct(tempProduct);
			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void closeApp(ActionEvent event)
	{
		//MainLoginApplication.getMain().getPrimaryStage().close();
		getDialogStage().close();
	}
}
