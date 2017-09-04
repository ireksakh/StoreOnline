package com.application.Service;

import com.application.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Integer id);

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer id);
}
