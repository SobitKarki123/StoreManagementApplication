package mum.store.model;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;

public class SaleDetail {
	private DoubleProperty price;
    private IntegerProperty qty;
    private DoubleProperty itemAmount;
    private IntegerProperty smasterId;
    private IntegerProperty itemId;
    private IntegerProperty sDetailId;

    public SaleDetail(){}

    public Double getPrice() {
        return price.get();
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public Integer getQty() {
        return qty.get();
    }

    public void setQty(Integer qty) {
        this.qty.set(qty);
    }

    public IntegerProperty qtyProperty() {
        return qty;
    }

    public Double getItemAmount() {
        return itemAmount.get();
    }

    public void setItemAmount(Double itemAmount) {
        this.itemAmount.set(itemAmount);
    }

    public DoubleProperty itemAmountProperty() {
        return itemAmount;
    }

    public Integer getSmasterId() {
        return smasterId.get();
    }

    public void setSmasterId(Integer smasterId) {
        this.smasterId.set(smasterId);
    }

    public IntegerProperty sMasterIdProperty() {
        return smasterId;
    }

    public Integer getItemId() {
        return itemId.get();
    }

    public void setItemId(Integer itemId) {
        this.itemId.set(itemId);
    }

    public IntegerProperty itemIdProperty() {
        return itemId;
    }

    public Integer getSdetailId() {
        return sDetailId.get();
    }

    public void setSdetailId(Integer sDetailId) {
        this.sDetailId.set(sDetailId);
    }

    public IntegerProperty pDetailIdProperty() {
        return sDetailId;
    }
}
