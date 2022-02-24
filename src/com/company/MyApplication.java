package com.company;

import com.company.controllers.CityController;
import com.company.entities.City;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final CityController controller;
    private final Scanner scanner;

    public MyApplication(CityController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all users");
            System.out.println("2. Get user by id");
            System.out.println("3. Create user");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCitiesMenu();
                } else if (option == 2) {
                    getCityByIdMenu();
                } else if (option == 3) {
                    createCityMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllCitiesMenu() {
        String response = controller.getAllCities();
        System.out.println(response);
    }

    public void getCityByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getCity(id);
        System.out.println(response);
    }

    public void createCityMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter headcount");
        int headcount = Integer.parseInt(scanner.next());
        System.out.println("Please enter region");
        String region = scanner.next();
        System.out.println("Please enter longitude");
        Double x = scanner.nextDouble();
        System.out.println("Please enter latitude");
        Double y = scanner.nextDouble();
        String response = controller.createCity(id, name, headcount, region, x, y);
        System.out.println(response);
    }
}