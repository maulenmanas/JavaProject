package com.company.repositories.interfaces;

import com.company.entities.City;
import com.company.entities.Edge;
import com.company.entities.IndustrialCity;

import java.util.List;

public interface ICityRepository {
    boolean createCity(City locality);
    boolean createIndustrialCity(IndustrialCity locality);
    City getCity(int id);
    City getCity(String name);
    //List <Edge> ShortestPath(City a, City b);
    List<City> getAllCities();
    List<IndustrialCity> getAllICities();
}