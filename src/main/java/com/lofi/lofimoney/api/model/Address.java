package com.lofi.lofimoney.api.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

    @NotNull
    @Size(max = 50)
    private String publicPlace;

    @NotNull
    @Size(max = 50)
    private String number;

    @NotNull
    @Size(max = 50)
    private String complement;

    @NotNull
    @Size(max = 50)
    private String district;

    @NotNull
    @Size(max = 50)
    private String zipCode;

    @NotNull
    @Size(max = 50)
    private String city;

    @NotNull
    @Size(max = 50)
    private String state;

    public Address(String publicPlace, String number, String complement, String district, String zipCode, String city,
                   String state) {
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public Address() {

    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) { this.publicPlace = publicPlace; }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
