package com.company;

import java.util.*;

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
            System.out.println("2. Get city by attribute");
            System.out.println("3. Create city");
            System.out.println("4. Get all industrial cities");
            System.out.println("5. Get Distance between 2 cities");
            System.out.println("6. Filter by headcount");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCitiesMenu();
                } else if (option == 2) {
                    getCityByAtributeMenu();
                } else if (option == 3) {
                    createCityMenu();
                }else if (option == 4) {
                    getAllICitiesMenu();
                }else if (option == 5) {
                    getDistanceMenu();
                }else if (option == 6) {
                    headCountFilterMenu();
                }else {
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

    private void headCountFilterMenu() {
        System.out.println("more or less than set value (1/2) ");
        int filter = scanner.nextInt();
        System.out.println("value of headcount");
        int value = scanner.nextInt();
        if (filter==1){
            List<String> response;
            response = controller.headCountFilter(">",value);
            System.out.println(response);
        }
        if (filter==2){
            List<String> response;
            response = controller.headCountFilter("<",value);
            System.out.println(response);
        }
    }
    private void getDistanceMenu() {
        System.out.println("Enter 1 name of City");
        String from="";

        do {
            if(from.length() > 0){
                System.out.println("There is no city with that name in database(try to add it first)");
            }
            System.out.println("Please enter departure city");
            from = scanner.next();
        }while(controller.getCityByAtribute("name", from).length() < 5);

        System.out.println("Enter 2 name of City");
        String to = "";

        do {
            if(to.length() > 0){
                System.out.println("There is no city with that name in database(try to add it first)");
            }
            System.out.println("Please enter host city");
            to = scanner.next();
        }while(controller.getCityByAtribute("name", to).length() < 5);

        double response;
        response = controller.getDistance(from,to);
        System.out.println(response);
    }

    /*private void getNameById() {
        int id = scanner.nextInt();
        String response;
        response = controller.getNameById(id);
        System.out.println(response);
    }

    private void getIdByName() {
        String name = scanner.next();
        String response;
        response = String.valueOf(controller.getIdByName(name));
        System.out.println(response);
    }*/

    private void getCityByAtributeMenu() {
        System.out.println("Enter atribute");
        System.out.println("1. id");
        System.out.println("2. name");
        System.out.println("3. region");

        try{
            int option = scanner.nextInt();
            if (option==1){
                System.out.println("Enter id of city");
                int id = scanner.nextInt();
                String response;
                response = controller.getCityByAtribute("id", String.valueOf(id));
                System.out.println(response);
            }
            if (option==2){
                System.out.println("Enter name of city");
                String name = scanner.next();
                String response;
                response = controller.getCityByAtribute("name", name);
                System.out.println(response);
            }
            if (option==3){
                System.out.println("Enter region of city");
                String region = scanner.next();
                String response;
                response = controller.getCityByAtribute("region", region);
                System.out.println(response);
            }

        }catch (InputMismatchException e){
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
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