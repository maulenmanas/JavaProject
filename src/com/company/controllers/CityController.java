package com.company.controllers;

import com.company.entities.City;
import com.company.entities.IndustrialCity;
import com.company.repositories.interfaces.ICityRepository;

import java.util.List;

public class CityController {
    private final ICityRepository repo;

    public CityController(ICityRepository repo) {
        this.repo = repo;
    }

    public String createCity(int id, String name, int headcount, String region, double x, double y, String product, int amount) {
        //boolean male = (gender.toLowerCase().equals("male"));
        IndustrialCity locality= new IndustrialCity(id, name, headcount, region, x, y, product, amount);

        boolean created = repo.createCity(locality);

        return (created ? "City was created!" : "City creation was failed!");
    }

    public String getCity(int id) {
        City locality= repo.getCity(id);

        return (locality == null ? "City was not found!" : locality.toString());
    }

    public String getAllCities() {
        List<City> localities = repo.getAllCities();

        return localities.toString();
    }


}