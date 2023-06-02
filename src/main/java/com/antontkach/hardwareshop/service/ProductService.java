package com.antontkach.hardwareshop.service;

import com.antontkach.hardwareshop.model.Product;
import com.antontkach.hardwareshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllByType(String type) {
        return productRepository.findByProductType(type);
    }

    public Product getById(int id) {
        return productRepository.getExisted(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteExisted(id);
    }
}
