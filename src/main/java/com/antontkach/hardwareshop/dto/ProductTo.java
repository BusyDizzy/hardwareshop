package com.antontkach.hardwareshop.dto;


import com.antontkach.hardwareshop.model.Desktop;
import com.antontkach.hardwareshop.model.Laptop;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private int screenSize;

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
}
