package mum.store.model;



import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SaleMaster {
	private StringProperty billNumber;
	private StringProperty saleDate;
	private DoubleProperty totalAmount;
	private IntegerProperty sMId;

	public SaleMaster(String billNumber, String purchaseDate, Double totalAmount) {
		this.billNumber = new SimpleStringProperty(billNumber);
		this.saleDate = new SimpleStringProperty(purchaseDate);
		this.totalAmount = new SimpleDoubleProperty(totalAmount);
		this.sMId = new SimpleIntegerProperty(0);
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

	public String getSaleDate() {
		return saleDate.get();
	}

	public void setSaleDate(String purchaseDate) {
		this.saleDate.set(purchaseDate);
	}

	public StringProperty saleDateProperty() {
		return saleDate;
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

	public Integer getSMId() {
		return sMId.get();
	}

	public void setPMId(Integer sMId) {
		this.sMId.set(sMId);
	}

	public IntegerProperty sMIdProperty() {
		return sMId;
	}
}

