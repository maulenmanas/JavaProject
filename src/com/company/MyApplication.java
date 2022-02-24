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
            System.out.println("1. Get all cities");
            System.out.println("2. Get city by id");
            System.out.println("3. Create city");
            System.out.println("4. Get all industrial cities");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCitiesMenu();
                } else if (option == 2) {
                    getCityByIdMenu();
                } else if (option == 3) {
                    createCityMenu();
                }else if (option == 4) {
                    getAllICitiesMenu();
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

    public void getAllICitiesMenu() {
        String response = controller.getAllICities();
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
        double x = scanner.nextDouble();
        System.out.println("Please enter latitude");
        double y = scanner.nextDouble();
        System.out.println("Is it industrial city? (1-yes, 0-no)");
        int option = scanner.nextInt();
        String response;
        if (option == 0) {
            response = controller.createCity(id, name, headcount, region, x, y, "Nothing", 0);
        }
        else {
            System.out.println("Please enter product");
            String product = scanner.next();
            System.out.println("Please enter amount in tonne");
            int amount = scanner.nextInt();
            response = controller.createCity(id, name, headcount, region, x, y, product, amount);
        }
        System.out.println(response);
    }
}