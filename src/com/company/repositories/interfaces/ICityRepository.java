package com.company.repositories.interfaces;

import com.company.entities.City;
import com.company.entities.Edge;
import com.company.entities.IndustrialCity;

import java.util.List;

public interface ICityRepository {
    boolean createCity(IndustrialCity locality);
    List<City> getCityByAttribute(String attribute_name, String attribute);
    int getIDbyName(String a);
    boolean addEdge(Edge edge);
    List<Edge> getAllEdges();
    int ShortestPath(String a, String b);
    List<City> getAllCities();
    List<IndustrialCity> getAllICities();
}