package com.crudapp.crudapp.service;

import com.crudapp.crudapp.modele.Product;
import com.crudapp.crudapp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements  ProductService{

    private final ProductRepository productRepository;
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> read() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Long id, Product product) {
        return productRepository.findById(id)
                .map(p->{
                    p.setPrice(product.getPrice());
                    p.setName(product.getName());
                    p.setDescription(product.getDescription());
                    return productRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @Override
    public String delete(Long id) {
        productRepository.deleteById(id);
        return "product delete";
    }
}
