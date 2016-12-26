package mum.store.bal;

import java.util.HashMap;

import javafx.collections.ObservableList;
import mum.store.model.Product;
import mum.store.model.SaleMaster;
import mum.store.repository.SaleRepository;

public class SaleManager {


	public boolean insertSale(ObservableList<Product> list, SaleMaster sd) {
		
		HashMap<SaleMaster, ObservableList<Product>> saleMap = new HashMap<>();

		saleMap.put(sd, list);

		SaleRepository saleRepo=new SaleRepository();
		return saleRepo.add(saleMap);
	}

}


