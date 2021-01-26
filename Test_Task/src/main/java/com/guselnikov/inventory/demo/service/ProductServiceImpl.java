package com.guselnikov.inventory.demo.service;

import com.guselnikov.inventory.demo.dao.ProductRepository;
import com.guselnikov.inventory.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(int id) {
        Product product = null;
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()){
            product = optional.get();
        }
        return product;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllName(String name) {
        List<Product> products = productRepository.findAllByName(name);
        return products;
    }

    @Override
    public List<Product> findAllMark(String mark) {
        List<Product> products = productRepository.findAllByMark(mark);
        return products;
    }
}
