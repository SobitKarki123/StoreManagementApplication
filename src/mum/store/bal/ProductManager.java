package mum.store.bal;

import java.util.List;

import mum.store.model.Product;
import mum.store.repository.ProductRepository;

public class ProductManager {
	private Product product;
	ProductRepository prepo = new ProductRepository();

	public boolean insertProduct(Product product) {
		boolean status = prepo.add(product);
		return status;
	}

	public List<Product> getAllProducts() {
		return prepo.list();
	}

}
