package com.company;

import com.company.controllers.CityController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.CityRepository;
import com.company.repositories.interfaces.ICityRepository;


public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        ICityRepository repo = new CityRepository(db);
        CityController controller = new CityController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}