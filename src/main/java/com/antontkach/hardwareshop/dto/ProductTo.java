package com.antontkach.hardwareshop.dto;


import com.antontkach.hardwareshop.model.Desktop;
import com.antontkach.hardwareshop.model.Laptop;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class ProductTo extends BaseTo {
    @NotBlank
    private String serialNumber;

    @NotBlank
    private String manufacturer;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @Positive
    private int quantity;

    @NotBlank
    private String productType;

    // Additional fields for Desktop
    private String formFactor;

    // Additional fields for Laptop
    private Integer screenSize;

    // Additional fields for Monitor
    private Long diagonal;

    // Additional fields for HarDrive
    private String capacity;

    public ProductTo(Integer id, String serialNumber, String manufacturer, BigDecimal price, int quantity,
                     String productType, String formFactor, Integer screenSize, Long diagonal, String capacity) {
        super(id);
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
        this.formFactor = formFactor;
        this.screenSize = screenSize;
        this.diagonal = diagonal;
        this.capacity = capacity;
    }

    public Desktop.FormFactor convertToFormFactor(String formFactorString) {
        return switch (formFactorString) {
            case "DESKTOP" -> Desktop.FormFactor.DESKTOP;
            case "NETTOP" -> Desktop.FormFactor.NETTOP;
            case "MONOBLOCK" -> Desktop.FormFactor.MONOBLOCK;
            default -> throw new IllegalArgumentException("Invalid form factor: " + formFactorString);
        };
    }

    public Laptop.Size convertToSize(int screenSize) {
        return switch (screenSize) {
            case 13 -> Laptop.Size.SIZE_13;
            case 14 -> Laptop.Size.SIZE_14;
            case 15 -> Laptop.Size.SIZE_15;
            case 17 -> Laptop.Size.SIZE_17;
            default -> throw new IllegalArgumentException("Invalid screen size: " + screenSize);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductTo productTo = (ProductTo) o;
        return quantity == productTo.quantity
                && Objects.equals(serialNumber, productTo.serialNumber)
                && Objects.equals(manufacturer, productTo.manufacturer)
                && Objects.equals(price, productTo.price)
                && Objects.equals(productType, productTo.productType)
                && Objects.equals(formFactor, productTo.formFactor)
                && Objects.equals(screenSize, productTo.screenSize)
                && Objects.equals(diagonal, productTo.diagonal)
                && Objects.equals(capacity, productTo.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), serialNumber, manufacturer, price, quantity, productType, formFactor,
                screenSize, diagonal, capacity);
    }
}
