package com.guselnikov.inventory.demo.service;

import com.guselnikov.inventory.demo.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public void saveProduct(Product product);

    public Product getProduct(int id);

    public void deleteProduct(int id);

    public List<Product> findAllName(String name);

    public List<Product> findAllMark(String mark);
}
