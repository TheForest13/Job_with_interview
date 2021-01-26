package com.guselnikov.inventory.demo.dao;

import com.guselnikov.inventory.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findAllByName(String name);
    public List<Product> findAllByMark(String mark);

}
