/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbo.fbg.stein.owmgeolocapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Matthias Stein
 */
public class OWMGeoLocAppTest {

    private static final Logger LOG = LogManager.getLogger(OWMGeoLocAppTest.class);

    public static void main(String[] args) {
        WeatherRetriever retriever = new WeatherRetriever();

        LOG.info(retriever);
        try {
            Weather weather = retriever.retrieve(new City("Bochum", "Germany"));
            LOG.info(weather);
        } catch (UnsupportedCountryException e) {
            LOG.error("This country is not supported", e);
        }

        try {
            Weather weather = retriever.retrieve(new City("Sydney", "Australia"));
            LOG.info(weather);
        } catch (UnsupportedCountryException e) {
            LOG.error("This country is not supported", e);
        }
    }
}
