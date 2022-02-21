package com.company.repositories.interfaces;

import com.company.entities.Locality;

import java.util.List;

public interface IUserRepository {
    boolean createUser(Locality locality);
    Locality getLocality(int id);
    List<Locality> getAllUsers();
}