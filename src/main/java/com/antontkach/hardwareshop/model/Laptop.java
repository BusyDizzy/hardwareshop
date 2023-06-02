package com.antontkach.hardwareshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Laptop")
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
}
