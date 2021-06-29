package com.lofi.lofimoney.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@EqualsAndHashCode
@Data
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long code;

    @Column(name = "name")
    private String name;

    public Category(Long cdde, String name) {
        this.code = code;
        this.name = name;
    }

    public Category() {

    }
}
