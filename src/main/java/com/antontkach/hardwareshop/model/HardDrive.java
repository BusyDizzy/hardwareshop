package com.antontkach.hardwareshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HardDrive extends Product {
    @NotBlank
    @NotNull
    @Column(name = "capacity")
    private String capacity;

    public HardDrive(Integer id, String serialNumber, String manufacturer, BigDecimal price,
                     int quantity, String capacity, String productType) {
        super(id, serialNumber, manufacturer, price, quantity, productType);
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HardDrive hardDrive = (HardDrive) o;
        return Objects.equals(capacity, hardDrive.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }
}