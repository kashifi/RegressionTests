/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engcpp.utils;

/**
 *
 * @author engcpp
 */
public class Address {
    private String number;
    private String street;
    private String streetType;
    private String suburb;
    private String city;
    
    private boolean lookup;
    
    public String getNumber() {
      return number;
    }

    public Address withNumber(String number) {
      this.number = number;
      return this;
    }

    public String getStreet() {
      return street;
    }

    public Address withStreet(String street) {
      this.street = street;
      return this;
    }

    public String getStreetType() {
      return streetType;
    }

    public Address withStreetType(String streetType) {
      this.streetType = streetType;
      return this;
    }

    public String getSuburb() {
        return suburb;
    }

    public Address withSuburb(String suburb) {
      this.suburb = suburb;
      return this;
    }

    public String getCity() {
        return city;
    }

    public Address withCity(String city) {
      this.city = city;
      return this;
    }

	public boolean isLookup() {
		return lookup;
	}

	public Address useLookup(boolean lookup) {
		this.lookup = lookup;
		return this;
	}        
}