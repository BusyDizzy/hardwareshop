package com.antontkach.hardwareshop.model;

import com.antontkach.hardwareshop.HasId;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "products", uniqueConstraints = {@UniqueConstraint(columnNames = {"serial_number", "manufacturer"},
        name = "product_unique_serial_number_manufacturer_idx")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "product_type")
public class Product implements HasId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // https://stackoverflow.com/a/28025008/548473
    private Integer id;

    @Column(name = "serial_number", nullable = false)
    @NotNull
    @NotBlank
    private String serialNumber;

    @Column(name = "manufacturer", nullable = false)
    @NotNull
    @NotBlank
    private String manufacturer;

    @Column(name = "price", nullable = false)
    @Range(min = 1, max = 1000000)
    private BigDecimal price;

    @NotNull
    @Column(name = "quantity", nullable = false)
    @Range(min = 1, max = 1000000)
    private int quantity;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity
                && Objects.equals(id, product.id)
                && Objects.equals(serialNumber, product.serialNumber)
                && Objects.equals(manufacturer, product.manufacturer)
                && Objects.equals(price, product.price)
                && Objects.equals(productType, product.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, manufacturer, price, quantity, productType);
    }
}