package com.lofi.lofimoney.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@Data
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "active")
    private Boolean active;

    @Embedded
    @AttributeOverrides(value = {
        @AttributeOverride(name = "publicPlace", column = @Column(name = "public_place")),
        @AttributeOverride(name = "number", column = @Column(name = "number")),
        @AttributeOverride(name = "complement", column = @Column(name = "complement")),
        @AttributeOverride(name = "district", column = @Column(name = "district")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code")),
        @AttributeOverride(name = "city", column = @Column(name = "city")),
        @AttributeOverride(name = "state", column = @Column(name = "state"))
    })
    private Address address;

    public Person(String name, boolean active, Address address) {
        this.name = name;
        this.active = active;
        this.address = address;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
