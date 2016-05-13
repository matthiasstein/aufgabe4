/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbo.fbg.stein.owmgeolocapp;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitpipeline.lib.owm.OwmClient;
import org.bitpipeline.lib.owm.WeatherData;
import org.bitpipeline.lib.owm.WeatherData.WeatherCondition;
import org.bitpipeline.lib.owm.WeatherStatusResponse;
import org.json.JSONException;

/**
 *
 * @author Matthias Stein
 */
public class WeatherRetriever {
    
    private static final Logger LOG = LogManager.getLogger(WeatherRetriever.class);

    /**
     *
     * @param city
     * @return weather object providing information on current conditions
     * @throws UnsupportedCountryException country is not supported
     */
    public Weather retrieve(City city) throws UnsupportedCountryException {
        if (city.getName().equals("Sydney") || city.getCountry().equals("Australia")) {
            throw new UnsupportedCountryException();
        } else {
            OwmClient owm = new OwmClient();
            String description = null;
            double temp = 0, pressure = 0, humidity = 0, rain = 0, windspeed = 0;
            try {
                WeatherStatusResponse currentWeather = owm.currentWeatherAtCity(city.getName(), city.getCountry());
                if (currentWeather.hasWeatherStatus()) {
                    WeatherData weather = currentWeather.getWeatherStatus().get(0);
                    WeatherCondition weatherCondition = weather.getWeatherConditions().get(0);
                    description = weatherCondition.getDescription();
                    temp = weather.getTemp();
                    pressure = weather.getPressure();
                    humidity = weather.getHumidity();
                    rain = weather.getRain();
                    windspeed = weather.getWindSpeed();
                }
            } catch (IOException | JSONException ex) {
                LOG.error(ex.getMessage());
            }
            return new Weather(description, temp, pressure, humidity, rain, windspeed);
        }
    }
    
}
