package com.crudapp.crudapp.controller;

import com.crudapp.crudapp.modele.Product;
import com.crudapp.crudapp.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductRestController {
    private final ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("/read")
    public List<Product> read(){
        return productService.read();
    }

    @PutMapping("/update/{id}")
    public  Product update(@PathVariable Long id,@RequestBody Product product){
        return productService.update(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return productService.delete(id);
    }
}
