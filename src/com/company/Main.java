package com.company;

import com.company.controllers.CityController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.CityRepository;
import com.company.repositories.interfaces.ICityRepository;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
          /*String connectionUrl = "jdbc:postgresql://localhost:5432/cities";
          Connection con = null;
          ResultSet rs = null;
          Statement stmt = null;
        try {
             // Here we load the driver’s class file into memory at the runtime
             Class.forName("org.postgresql.Driver");

//            // Establish the connection
             con = DriverManager.getConnection(connectionUrl, "postgres", "12341234");
//
             // The object of statement is responsible to execute queries with the database
             stmt = con.createStatement();
//
//            // The executeQuery() method of Statement interface is used to execute queries
//            // to the database. This method returns the object of ResultSet that can be
//            // used to get all the records of a table that matches the sql statement
             //rs = stmt.executeQuery("select mistake * from citylist");
//
             /*while (rs.next())
                 System.out.println(rs.getInt("id") + "  "
                         + rs.getString("name") + "  " + rs.getInt("headcount") + "  "
                         + rs.getString("region") + "  " + rs.getDouble("x") + "  " + rs.getDouble("y")
                         + rs.getString("product") + "  " + rs.getInt("amount") + "  " + rs.getBoolean("type"));
         }
         catch (Exception e) {
             System.out.println("Exception occurred!");
         } finally {

             try {
                 con.close();
             } catch (Exception e) {
                 System.out.println("Exception occurred!");
             }
         }*/

         //System.out.println("Finished!");

        // Here you specify which DB and UserRepository to use
        // And changing DB should not affect to whole code
        IDB db = new PostgresDB();
        ICityRepository repo = new CityRepository(db);
        CityController controller = new CityController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}