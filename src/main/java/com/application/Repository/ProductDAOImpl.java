package com.application.Repository;

import com.application.Model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO{

@PersistenceContext
private EntityManager entityManager;

@SuppressWarnings("unchecked")
@Override
    public List<Product> getAllProducts() {
        String hql="FROM Product";
        return (List<Product>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Product getProductById(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void createProduct(Product product) {
entityManager.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product product1=getProductById(product.getId());
        product1.setProduct_name(product.getProduct_name());
product1.setPrice(product.getPrice());
    entityManager.flush();
    }

    @Override
    public void deleteproduct(Integer id) {
entityManager.remove(getProductById(id));
    }

    @Override
    public boolean productExists(String product_name, Integer price) {
        return false;
    }
}
