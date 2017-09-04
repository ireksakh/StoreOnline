package com.application.Repository;

import com.application.Model.Product;

import java.util.List;

public interface ProductDAO {
List<Product> getAllProducts();
Product getProductById(Integer id);
void createProduct(Product product);
void updateProduct (Product product);
void deleteproduct (Integer id);
boolean productExists (String product_name, Integer price);

}
