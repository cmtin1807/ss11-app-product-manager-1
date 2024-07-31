package com.example.app_product_manager.service;

import com.example.app_product_manager.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static List<Product> products;
    static {
        products = new ArrayList<Product>();
        products.add(new Product(1,"Iphone 6","Iphone","San pham cham",1000));
        products.add(new Product(2,"Iphone 6s","Iphone","San pham nhanh",2000));
        products.add(new Product(3,"Xiaomi 12","Xiaomi","San pham cu chuoi",1200));
        products.add(new Product(4,"Samsung S22","Samsung","San pham kha nhanh",12200));
        products.add(new Product(5,"Iphone 16Pro Max","Iphone","San pham qua nhanh",30000));
    }

    @Override
    public List<Product> findAllProducts() {
        return products;
    }

    @Override
    public Product findProductById(int id) {
      for (Product product : products) {
          if (product.getId() == id) {
              return product;
          }
      }
      return null;
    }

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(int id, Product updatedProduct) {
        Product existingProduct = findProductById(id);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setCompany(updatedProduct.getCompany());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
        }
    }


    @Override
    public void deleteProduct(int id) {
        Product productToDelete = findProductById(id);
        if (productToDelete != null) {
            products.remove(productToDelete);
        }
    }
}
