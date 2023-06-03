package com.antontkach.hardwareshop.service;

import com.antontkach.hardwareshop.dto.ProductTo;
import com.antontkach.hardwareshop.model.Product;
import com.antontkach.hardwareshop.repository.ProductRepository;
import com.antontkach.hardwareshop.web.convertor.ConvertorTo;
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

    public Product save(ProductTo productTo) {
        new Product();
        Product product = switch (productTo.getProductType()) {
            case "Desktop" -> ConvertorTo.createDesktop(productTo);
            case "Laptop" -> ConvertorTo.createLaptop(productTo);
            case "Monitor" -> ConvertorTo.createMonitor(productTo);
            case "Hard Drive" -> ConvertorTo.createHardDrive(productTo);
            default -> throw new IllegalArgumentException("Invalid product type: " + productTo.getProductType());
        };
        return productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteExisted(id);
    }

    public void update(Integer id, ProductTo updatedProduct) {
        Product product = getById(id);
        product.setSerialNumber(updatedProduct.getSerialNumber());
        product.setManufacturer(updatedProduct.getManufacturer());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());

        // Check the product type and update the specific fields accordingly
        ConvertorTo.updateProductSpecificFields(product, updatedProduct);
        productRepository.save(product);
    }
}
