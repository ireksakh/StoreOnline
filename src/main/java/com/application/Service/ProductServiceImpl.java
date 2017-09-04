package com.application.Service;

import com.application.Model.Product;
import com.application.Repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
private ProductDAO productDAO;
    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(Integer id) {
        Product obj=productDAO.getProductById(id);
        return obj;
    }

    @Override
    public void createProduct(Product product) {
    productDAO.createProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
productDAO.deleteproduct(id);
    }
}
