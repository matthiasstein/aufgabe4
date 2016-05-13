/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbo.fbg.stein.owmgeolocapp;

/**
 * class that represents a city
 *
 * @author Matthias Stein
 */
public class City {

    private String name, country;

    /**
     * constructor
     *
     * @param name city name
     * @param country country name
     */
    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

}
