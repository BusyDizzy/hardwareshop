package com.antontkach.hardwareshop.web.convertor;

import com.antontkach.hardwareshop.dto.ProductTo;
import com.antontkach.hardwareshop.model.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConvertorTo {

    public static Product convertProductToProduct(ProductTo productTo) {
        new Product();
        Product product = switch (productTo.getProductType()) {
            case "Desktop" -> createDesktop(productTo);
            case "Laptop" -> createLaptop(productTo);
            case "Monitor" -> createMonitor(productTo);
            case "Hard Drive" -> createHardDrive(productTo);
            default -> throw new IllegalArgumentException("Invalid product type: " + productTo.getProductType());
        };

        product.setId(productTo.getId());
        product.setSerialNumber(productTo.getSerialNumber());
        product.setManufacturer(productTo.getManufacturer());
        product.setPrice(productTo.getPrice());
        product.setQuantity(productTo.getQuantity());
        product.setProductType(productTo.getProductType());

        updateProductSpecificFields(product, productTo);
        return product;
    }

    public void updateProductSpecificFields(Product product, ProductTo updatedProduct) {
        switch (product.getProductType()) {
            case "Desktop" -> updateDesktopFields((Desktop) product, updatedProduct);
            case "Laptop" -> updateLaptopFields((Laptop) product, updatedProduct);
            case "Monitor" -> updateMonitorFields((Monitor) product, updatedProduct);
            case "Hard Drive" -> updateHardDriveFields((HardDrive) product, updatedProduct);
            default -> throw new IllegalArgumentException("Invalid product type: " + updatedProduct.getProductType());
        }
    }

    private void updateDesktopFields(Desktop desktop, ProductTo updatedProduct) {
        desktop.setFormFactor(updatedProduct.convertToFormFactor(updatedProduct.getFormFactor()));
    }

    private void updateLaptopFields(Laptop laptop, ProductTo updatedProduct) {
        laptop.setSize(updatedProduct.convertToSize(updatedProduct.getScreenSize()));
    }

    private void updateMonitorFields(Monitor monitor, ProductTo updatedProduct) {
        monitor.setDiagonal(updatedProduct.getDiagonal());
    }

    private void updateHardDriveFields(HardDrive hardDrive, ProductTo updatedProduct) {
        hardDrive.setCapacity(updatedProduct.getCapacity());
    }

    public Desktop createDesktop(ProductTo productTo) {
        return new Desktop(
                null,
                productTo.getSerialNumber(),
                productTo.getManufacturer(),
                productTo.getPrice(),
                productTo.getQuantity(),
                productTo.convertToFormFactor(productTo.getFormFactor()),
                productTo.getProductType()
        );
    }

    public Laptop createLaptop(ProductTo productTo) {
        return new Laptop(
                null,
                productTo.getSerialNumber(),
                productTo.getManufacturer(),
                productTo.getPrice(),
                productTo.getQuantity(),
                productTo.convertToSize(productTo.getScreenSize()),
                productTo.getProductType()
        );
    }

    public Monitor createMonitor(ProductTo productTo) {
        return new Monitor(
                null,
                productTo.getSerialNumber(),
                productTo.getManufacturer(),
                productTo.getPrice(),
                productTo.getQuantity(),
                productTo.getDiagonal(),
                productTo.getProductType()
        );
    }

    public HardDrive createHardDrive(ProductTo productTo) {
        return new HardDrive(
                null,
                productTo.getSerialNumber(),
                productTo.getManufacturer(),
                productTo.getPrice(),
                productTo.getQuantity(),
                productTo.getCapacity(),
                productTo.getProductType()
        );
    }
}