package com.mattoffe.Eccomerce.controllers;

import com.mattoffe.Eccomerce.dtos.ProductDTO;
import com.mattoffe.Eccomerce.model.Product;
import com.mattoffe.Eccomerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/all")
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductDTO::new).collect(toList());
    }
    @GetMapping("/{id}")
    public ProductDTO getOneProduct(@PathVariable Long id) {
        return new ProductDTO(productRepository.findById(id).orElse(null));
    }
    @PatchMapping("/updateStock/{id}")
    public ResponseEntity<Object> updateStock(@PathVariable Long id, @RequestParam int stock) {
       if (stock < 0) {
           return new ResponseEntity<>("Invalid stock", HttpStatus.BAD_REQUEST);
       }
        Product product = productRepository.findById(id).orElse(null);
        product.setStock(product.getStock() + stock);
        productRepository.save(product);
        return new ResponseEntity<>("Stock updated", HttpStatus.OK);
    }
    @PatchMapping("/updatePrice/{id}")
    public ResponseEntity<Object> updatePrice(@PathVariable Long id, @RequestParam double price) {
        Product product = productRepository.findById(id).orElse(null);
        if (price < 0) {
            return new ResponseEntity<>("Invalid price", HttpStatus.BAD_REQUEST);
        }
        if (price == product.getPrice()) {
            return new ResponseEntity<>("Price not changed", HttpStatus.OK);
        }
        product.setPrice(price);
        productRepository.save(product);
        return new ResponseEntity<>("Price updated", HttpStatus.OK);
    }
}
