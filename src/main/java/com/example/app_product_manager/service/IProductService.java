package com.example.app_product_manager.service;

import com.example.app_product_manager.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProducts();
    Product findProductById(int id);
    void saveProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);

}
