package com.ssi;


import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


//DAO (Data Access Object)
public class ProductRepository {
	//this class will contain the methods for performing CRUD operations on product table (data layer)
	
	public Product getProductDetails(int code) {
		Configuration config=new Configuration().configure();
		Session session=config.buildSessionFactory().openSession();
		Product product=session.get(Product.class, code);
		session.close();
		return product;
	}
	
}
