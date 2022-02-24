package com.company.repositories.interfaces;

import com.company.entities.City;
import com.company.entities.Edge;
import com.company.entities.IndustrialCity;

import java.util.List;

public interface ICityRepository {
    boolean createCity(IndustrialCity locality);
    List<City> getCityByAtribute(String atribute_name, String atribute);
    
    //boolean createEdge(Edge edge);
    //List <Edge> ShortestPath(City a, City b);
    List<City> getAllCities();
    List<IndustrialCity> getAllICities();

    int getIdByName(String name);

    String getNameById(int id);
}