package com.antontkach.hardwareshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products", uniqueConstraints = {@UniqueConstraint(columnNames = {"serial_number", "manufacturer"},
        name = "product_unique_serial_number_manufacturer_idx")})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}