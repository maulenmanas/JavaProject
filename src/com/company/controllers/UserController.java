package com.company.controllers;

import com.company.entities.Locality;
import com.company.repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo;

    public UserController(IUserRepository repo) {
        this.repo = repo;
    }

    public String createUser(String name, int m_amount, int w_amount, String region) {
        //boolean male = (gender.toLowerCase().equals("male"));
        Locality locality= new Locality(name, m_amount, w_amount,region);

        boolean created = repo.createUser(locality);

        return (created ? "User was created!" : "User creation was failed!");
    }

    public String getUser(int id) {
        Locality locality= repo.getLocality(id);

        return (locality == null ? "User was not found!" : locality.toString());
    }

    public String getAllUsers() {
        List<Locality> localities = repo.getAllUsers();

        return localities.toString();
    }
}