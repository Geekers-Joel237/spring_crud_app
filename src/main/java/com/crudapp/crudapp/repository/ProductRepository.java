package com.crudapp.crudapp.repository;

import com.crudapp.crudapp.modele.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
