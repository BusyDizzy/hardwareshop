package com.antontkach.hardwareshop.service;

import com.antontkach.hardwareshop.dto.ProductTo;
import com.antontkach.hardwareshop.model.Desktop;
import com.antontkach.hardwareshop.model.Laptop;
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

    public Product save(ProductTo productTo) {
        Product product = new Product();
        if (productTo.getProductType().equals("Desktop")) {
            product = new Desktop(null,
                    productTo.getSerialNumber(),
                    productTo.getManufacturer(),
                    productTo.getPrice(),
                    productTo.getQuantity(),
                    productTo.convertToFormFactor(productTo.getFormFactor()),
                    productTo.getProductType());
        } else if (productTo.getProductType().equals("Laptop")) {
            product = new Laptop(null, productTo.getSerialNumber(),
                    productTo.getManufacturer(),
                    productTo.getPrice(),
                    productTo.getQuantity(),
                    productTo.convertToSize(productTo.getScreenSize()),
                    productTo.getProductType());
        }
        return productRepository.save(product);
    }

    public void update(Integer id, ProductTo updatedProduct) {
        Product product = getById(id);
        product.setSerialNumber(updatedProduct.getSerialNumber());
        product.setManufacturer(updatedProduct.getManufacturer());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());

        // Check the product type and update the specific fields accordingly
        product = updateProductSpecificFields(product, updatedProduct);
        productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteExisted(id);
    }

    public Product updateProductSpecificFields(Product product, ProductTo updatedProduct) {
        if (product instanceof Desktop desktop && updatedProduct.getProductType().equals("Desktop")) {
            desktop.setFormFactor(updatedProduct.convertToFormFactor(updatedProduct.getFormFactor()));
        } else if (product instanceof Laptop laptop && updatedProduct.getProductType().equals("Laptop")) {
            laptop.setSize(updatedProduct.convertToSize(updatedProduct.getScreenSize()));
        } else {
            // Handle other product types if needed
            throw new IllegalArgumentException("Invalid product type: " + updatedProduct.getProductType());
        }
        return product;
    }
}
