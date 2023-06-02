package com.antontkach.hardwareshop.repository;

import com.antontkach.hardwareshop.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product> {
//    @Query(value = "select * from PRODUCTS where PRODUCT_TYPE =:type", nativeQuery = true)
    @Query("SELECT p FROM Product p WHERE p.productType=:type")
    List<Product> findByProductType(@Param("type") String type);
}