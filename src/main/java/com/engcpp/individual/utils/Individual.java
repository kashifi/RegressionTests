/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engcpp.individual.utils;

import com.engcpp.utils.Address;

/**
 *
 * @author engcpp
 */
public class Individual {
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String gender;
    private Address address;
    
    private Address[] previousAddresses;
    
    private String driverLicence;
    private String licenceVersion;
    
    private String occupation;
    private String employer;
    
    private String account;
    private String amount;
    
    private Reference reference;
    
    public String getGivenName() {
        return givenName;
    }

    public Individual withGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Individual withFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Individual withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }    

    public String getGender() {
        return gender;
    }

    public Individual withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Individual withAddress(Address address) {
        this.address = address;
        return this;
    }

    public Address[] getPreviousAddresses() {
        return previousAddresses;
    }

    public Individual withPreviousAddresses(Address...previousAddresses) {
        this.previousAddresses = previousAddresses;
        return this;
    }    
    
    public String getDriverLicence() {
        return driverLicence;
    }

    public Individual withDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
        return this;
    }

    public String getLicenceVersion() {
        return licenceVersion;
    }

    public Individual withLicenceVersion(String licenceVersion) {
        this.licenceVersion = licenceVersion;
        return this;
    }

    public String getOccupation() {
        return occupation;
    }

    public Individual withOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public String getEmployer() {
        return employer;
    }

    public Individual withEmployer(String employer) {
        this.employer = employer;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public Individual withAccount(String account) {
        this.account = account;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public Individual withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public Reference getReference() {
        return reference;
    }

    public Individual withReference(Reference reference) {
        this.reference = reference;
        return this;
    }
}
