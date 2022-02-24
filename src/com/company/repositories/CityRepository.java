package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.City;
import com.company.entities.IndustrialCity;
import com.company.repositories.interfaces.ICityRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CityRepository implements ICityRepository {
    private final IDB db;

    public CityRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCity(IndustrialCity locality) {
        System.out.println(locality.toString());
        Connection con = null;                          //create variable of connection
        try {
            con = db.getConnection();
            String sql = "INSERT INTO citylist(id,name,headcount,region,x,y,product,amount) VALUES (?,?,?,?,?,?,?,?)"; //sql command that create locality in our table
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, locality.getId());
            st.setString(2, locality.getName());
            st.setInt(3, locality.getHeadcount());
            st.setString(4,locality.getRegion());
            st.setDouble(5, locality.getX());
            st.setDouble(6,locality.getY());
            st.setString(7, locality.getProduct());
            st.setInt(8, locality.getAmount());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<City> getCityByAtribute(String attribute_name, String atribute) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,headcount,region,x,y FROM citylist WHERE "+attribute_name+"=?";
            PreparedStatement st = con.prepareStatement(sql);

            if (attribute_name=="id"){
                st.setInt(1, Integer.parseInt(atribute));
            }
            else{
                st.setString(1,atribute);
            }

            ResultSet rs = st.executeQuery();
            List<City> localities = new LinkedList<>();
            while (rs.next()) {
                City locality = new City(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("headcount"),
                        rs.getString("region"),
                        rs.getDouble("x"),
                        rs.getDouble("y"));

                localities.add(locality);
            }

            return localities;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<City> getAllCities() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,headcount,region,x,y FROM citylist";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<City> localities = new LinkedList<>();
            while (rs.next()) {
                City locality = new City(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("headcount"),
                        rs.getString("region"),
                        rs.getDouble("x"),
                        rs.getDouble("y"));

                localities.add(locality);
            }

            return localities;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<IndustrialCity> getAllICities() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,headcount,region,x,y,product,amount FROM citylist WHERE amount>0";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<IndustrialCity> localities = new LinkedList<>();
            while (rs.next()) {
                IndustrialCity locality = new IndustrialCity(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("headcount"),
                        rs.getString("region"),
                        rs.getDouble("x"),
                        rs.getDouble("y"),
                        rs.getString("product"),
                        rs.getInt("amount"));

                localities.add(locality);
            }

            return localities;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int getIdByName(String name){
        int id=0;
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id FROM citylist WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,name);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = (rs.getInt("id"));
            }
            return id;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
    @Override
    public String getNameById(int id){
        String name ="";
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name FROM citylist WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                name = (rs.getString("name"));
            }
            return name;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}