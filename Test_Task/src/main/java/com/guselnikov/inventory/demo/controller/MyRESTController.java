package com.guselnikov.inventory.demo.controller;

import com.guselnikov.inventory.demo.entity.Product;
import com.guselnikov.inventory.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyRESTController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> showAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return allProducts;
    }

    @GetMapping("/products/{id}")
    public Product showProduct(@PathVariable int id) {
        Product product = productService.getProduct(id);
        return product;
    }

    @PostMapping("/products")
    public Product addNewProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    @PutMapping("/products")
    public Product updateProducts(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/products")
    public String deleteProducts(@PathVariable int id) {
        Product product = productService.getProduct(id);
        productService.deleteProduct(id);
        return "Product with ID = " + id + " was deleted";
    }

    @GetMapping("/products/name/{name}")
    public List<Product> showAllProductByName(@PathVariable String name) {
        List<Product> products = productService.findAllName(name);
        return products;
    }
    @GetMapping("/products/mark/{mark}")
    public List<Product> showAllProductByMark(@PathVariable String mark) {
        List<Product> products = productService.findAllMark(mark);
        return products;
    }

    @GetMapping("/products/remains")
    public List<Product> showRemains() {
        List<Product> products = productService.getAllProducts();
        List<Product> remains = new ArrayList<>();
        for(Product product: products) {
            if(product.getAmount()<=5){
                remains.add(product);
            }
        }
        return remains;
    }
}
