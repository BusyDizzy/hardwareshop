package com.antontkach.hardwareshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
//@DiscriminatorValue("Laptop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Laptop extends Product {
    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private Size size;

    public enum Size {
        SIZE_13,
        SIZE_14,
        SIZE_15,
        SIZE_17
    }

    public Laptop(Integer id, String serialNumber, String manufacturer, BigDecimal price, int quantity, Size size,
                  String productType) {
        super(id, serialNumber, manufacturer, price, quantity, productType);
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return size == laptop.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}
