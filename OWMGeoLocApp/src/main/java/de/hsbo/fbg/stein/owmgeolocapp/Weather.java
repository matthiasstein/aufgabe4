/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbo.fbg.stein.owmgeolocapp;

/**
 * class that represents a weather object
 *
 * @author Matthias Stein
 */
public class Weather {

    private String description;
    private double temp, pressure, humidity, rain, windspeed;

    /**
     * constrcutor
     *
     * @param description weather description
     * @param temp temperature
     * @param pressure pressure
     * @param humidity humidity
     * @param rain rain
     * @param windspeed windspeed
     */
    public Weather(String description, double temp, double pressure, double humidity, double rain, double windspeed) {
        this.description = description;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.rain = rain;
        this.windspeed = windspeed;
    }

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getRain() {
        return rain;
    }

    public double getWindspeed() {
        return windspeed;
    }

    @Override
    public String toString() {
        return "Weather{" + "description=" + description + ", temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", rain=" + rain + ", windspeed=" + windspeed + '}';
    }

}
