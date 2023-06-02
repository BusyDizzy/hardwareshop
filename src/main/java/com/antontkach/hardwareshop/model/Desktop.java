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
//@DiscriminatorValue("Desktop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Desktop extends Product {

    @Enumerated(EnumType.STRING)
    @Column(name = "form_factor")
    private FormFactor formFactor;

    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }

    public Desktop(Integer id, String serialNumber, String manufacturer, BigDecimal price, int quantity,
                   FormFactor formFactor, String productType) {
        super(id, serialNumber, manufacturer, price, quantity, productType);
        this.formFactor = formFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Desktop desktop = (Desktop) o;
        return formFactor == desktop.formFactor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), formFactor);
    }
}