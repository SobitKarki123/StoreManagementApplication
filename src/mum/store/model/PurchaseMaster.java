package mum.store.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PurchaseMaster {
	private StringProperty billNumber;
	private StringProperty purchaseDate;
	private DoubleProperty totalAmount;
	private IntegerProperty pMId;

	public PurchaseMaster(String billNumber, String purchaseDate, Double totalAmount) {
		this.billNumber = new SimpleStringProperty(billNumber);
		this.purchaseDate = new SimpleStringProperty(purchaseDate);
		this.totalAmount = new SimpleDoubleProperty(totalAmount);
		this.pMId = new SimpleIntegerProperty(0);
	}

	public String getBillNumber() {
		return billNumber.get();
	}

	public void setBillNumber(String billNumber) {
		this.billNumber.set(billNumber);
	}

	public StringProperty billNumberProperty() {
		return billNumber;
	}

	public String getPurchaseDate() {
		return purchaseDate.get();
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate.set(purchaseDate);
	}

	public StringProperty purchaseDateProperty() {
		return purchaseDate;
	}

	public Double getTotalAmount() {
		return totalAmount.get();
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount.set(totalAmount);
	}

	public DoubleProperty totalAmountProperty() {
		return totalAmount;
	}

	public Integer getPMId() {
		return pMId.get();
	}

	public void setPMId(Integer pMId) {
		this.pMId.set(pMId);
	}

	public IntegerProperty pMIdProperty() {
		return pMId;
	}
}
