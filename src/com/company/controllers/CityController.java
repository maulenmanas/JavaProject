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

    public String getCityByAtribute(String atribute_name, String atribute) {
        List<City> localities= repo.getCityByAtribute(atribute_name, atribute);
        return (localities.toString());
    }

    public String getAllCities() {
        List<City> localities = repo.getAllCities();

        return localities.toString();
    }

    public String getAllICities() {
        List<IndustrialCity> localities = repo.getAllICities();

        return localities.toString();
    }

    public int getIdByName (String name){
        int id = repo.getIdByName(name);
        return id;
    }

    public String getNameById(int id) {
        String name = repo.getNameById(id);
        return name;
    }

    public double getDistance(String name1, String name2) {
        double distance = repo.getDistance(name1,name2);
        return distance;
    }

    public List<String> headCountFilter(String sign, int value) {
        List<String> names = repo.headCountFilter(sign,value);

        return names;
    }
}