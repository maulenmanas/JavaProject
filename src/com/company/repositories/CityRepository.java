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
    public boolean createCity(City locality) {
        Connection con = null;                          //create variable of connection
        try {
            con = db.getConnection();
            String sql = "INSERT INTO citylist(id,name,headcount,region,x,y,product,amount,type) VALUES (?,?,?,?,?,?,?,?,?)"; //sql command that create locality in our table
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, locality.getId());
            st.setString(2, locality.getName());
            st.setInt(3, locality.getHeadcount());
            st.setString(4,locality.getRegion());
            st.setDouble(5, locality.getX());
            st.setDouble(6,locality.getY());
            st.setString(7, "Nothing");
            st.setInt(8, 0);
            st.setBoolean(9, false);
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
    public boolean createIndustrialCity(IndustrialCity locality) {
        Connection con = null;                          //create variable of connection
        try {
            con = db.getConnection();
            String sql = "INSERT INTO citylist(id,name,headcount,region,x,y,product,amount,type) VALUES (?,?,?,?,?,?,?,?,?)"; //sql command that create locality in our table
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, locality.getId());
            st.setString(2, locality.getName());
            st.setInt(3, locality.getHeadcount());
            st.setString(4,locality.getRegion());
            st.setDouble(5, locality.getX());
            st.setDouble(6,locality.getY());
            st.setString(7, locality.getProduct());
            st.setInt(8, locality.getAmount());
            st.setBoolean(9, true);
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
    public City getCity(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,headcount,region,x,y FROM citylist WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                City locality = new City(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("headcount"),
                        rs.getString("region"),
                        rs.getDouble("x"),
                        rs.getDouble("y"));

                return locality;
            }
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
    public City getCity(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,headcount,region,x,y FROM citylist WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                City locality = new City(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("headcount"),
                        rs.getString("region"),
                        rs.getDouble("x"),
                        rs.getDouble("y"));

                return locality;
            }
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
            String sql = "SELECT id,name,headcount,region,x,y,product,amount FROM citylist WHERE type=true";
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
}