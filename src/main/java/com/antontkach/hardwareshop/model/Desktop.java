package com.antontkach.hardwareshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Desktop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Desktop extends Product {

    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "form_factor")
    private FormFactor formFactor;

    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }
}