package mum.store.bal;

import java.util.HashMap;

import javafx.collections.ObservableList;
import mum.store.model.Product;
import mum.store.model.PurchaseMaster;
import mum.store.repository.PurchaseRepository;

public class PurchaseManager {

	public boolean insertPurchase(ObservableList<Product> list, PurchaseMaster pd) {
		HashMap<PurchaseMaster, ObservableList<Product>> purchaseMap = new HashMap<>();
		purchaseMap.put(pd, list);
		PurchaseRepository purchaseRepo=new PurchaseRepository();
		return purchaseRepo.add(purchaseMap);
	}

}
