package com.ssi;

public class ProductService {
	// all the business logics related with products 
	
	ProductRepository repository=new ProductRepository();
	
	//Business-Logic
	public Product computeDiscount(int code) {
		//here first we need to fetch product details.
		Product product=repository.getProductDetails(code);
		int discount=0;
		int price=product.getPrice();
		if(price>=7000) {
			discount=price*20/100;
		}else {
			discount=price*10/100;
		}
		product.setDiscount(discount);
		return product;
	}
	
}
