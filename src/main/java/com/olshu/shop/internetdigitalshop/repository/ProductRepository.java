package com.olshu.shop.internetdigitalshop.repository;

import com.olshu.shop.internetdigitalshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductType(String productType);
}


