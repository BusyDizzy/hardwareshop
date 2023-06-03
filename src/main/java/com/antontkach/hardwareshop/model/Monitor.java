package com.antontkach.hardwareshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Monitor extends Product {

    @Column(name = "diagonal")
    @Range(min = 1, max = 200)
    private Long diagonal;

    public Monitor(Integer id, String serialNumber, String manufacturer, BigDecimal price, int quantity,
                   Long diagonal, String productType) {
        super(id, serialNumber, manufacturer, price, quantity, productType);
        this.diagonal = diagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monitor monitor = (Monitor) o;
        return Objects.equals(diagonal, monitor.diagonal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diagonal);
    }
}