package com.lofi.lofimoney.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode
@Data
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long code;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "name")
    private String name;

    public Category(Long cdde, String name) {
        this.code = code;
        this.name = name;
    }

    public Category() {

    }
}
