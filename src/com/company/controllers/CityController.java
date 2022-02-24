package com.company.controllers;

import com.company.entities.City;
<<<<<<< HEAD
=======
import com.company.entities.Edge;
>>>>>>> Manas
import com.company.entities.IndustrialCity;
import com.company.repositories.interfaces.ICityRepository;

import java.util.ArrayList;
import java.util.List;

public class CityController {
    private final ICityRepository repo;

    public CityController(ICityRepository repo) {
        this.repo = repo;
    }

    public String createCity(int id, String name, int headcount, String region, double x, double y, String product, int amount) {
<<<<<<< HEAD
        //boolean male = (gender.toLowerCase().equals("male"));
        IndustrialCity locality= new IndustrialCity(id, name, headcount, region, x, y, product, amount);

=======
        IndustrialCity locality= new IndustrialCity(id, name, headcount, region, x, y, product, amount);
>>>>>>> Manas
        boolean created = repo.createCity(locality);
        return (created ? "City was created!" : "City creation was failed!");
    }

<<<<<<< HEAD
    public String getCityByAtribute(String atribute_name, String atribute) {
        List<City> localities= repo.getCityByAtribute(atribute_name, atribute);
        return (localities.toString());
=======
    public String getCityByAttribute(String attribute_name, String attribute) {
        List<City> localities= repo.getCityByAttribute(attribute_name, attribute);
        return (localities.toString());
    }

    public String addEdge(int aid, int bid, String transport, int time){
        Edge edge = new Edge(aid, bid, transport, time);
        boolean created = repo.addEdge(edge);
        return (created ? "Edge was created!" : "Edge creation was failed!");
>>>>>>> Manas
    }

    public String getAllCities() {
        List<City> localities = repo.getAllCities();
        return localities.toString();
    }

    public String getAllICities() {
        List<IndustrialCity> localities = repo.getAllICities();
        return localities.toString();
    }

<<<<<<< HEAD
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
=======
    public int getIDbyName(String name){
        String s = getCityByAttribute("name", name);
        int pos = s.indexOf("id") + 2;
        while(!Character.isDigit(s.charAt(pos)))++pos;
        int id = 0;
        while(Character.isDigit(s.charAt(pos))){
            id *= 10;
            id += s.charAt(pos) - '0';
            ++pos;
        }
        return id;
    }

    public int ShortestPath(String from, String to) {
        int time = repo.ShortestPath(from, to);
        return time;
>>>>>>> Manas
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