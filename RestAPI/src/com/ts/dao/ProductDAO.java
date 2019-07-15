package com.ts.dao;

import java.util.List;
import com.rest.dto.*
;
import com.ts.db.HibernateTemplate;public class ProductDAO {
public Product getProduct(int productId) {
	return (Product)HibernateTemplate.ProductgetObjectByProductId(productId);
}

public int register(Product product) {
	return HibernateTemplate.addObject(product);
}

public List<Product> getAllProduct() {
	List<Product> product=(List)HibernateTemplate.getObjectListByQuery("From Product");
	System.out.println("Inside All Employees ..."+product);
	return product;	
}
}