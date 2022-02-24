package com.company.repositories;

import java.awt.*;
import java.util.*;
import com.company.data.interfaces.IDB;
import com.company.entities.City;
import com.company.entities.Edge;
import com.company.entities.IndustrialCity;
import com.company.repositories.interfaces.ICityRepository;

<<<<<<< HEAD

=======
import java.awt.*;
import java.util.*;
>>>>>>> Manas
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CityRepository implements ICityRepository {
    private final IDB db;

    public CityRepository(IDB db) {
        this.db = db;
    }

    @Override
    public double getDistance(String from, String to){
        City city1 = getCityByName(from);
        City city2 = getCityByName(to);
        return city1.absDistance(city2);
    }

<<<<<<< HEAD
=======
    @Override
    public City getCityByName(String name){
        List <City> list = getCityByAttribute("name", name);
        return list.get(0);
    }
>>>>>>> Manas

    @Override
    public List<String> headCountFilter(String sign, int value){
        List<String> names = new LinkedList<>();
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT name FROM citylist WHERE headcount " + sign + String.valueOf(value); //;"SELECT name FROM citylist WHERE headcount < 240"
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            List<City> localities = new LinkedList<>();
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
            return names;

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
<<<<<<< HEAD
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
=======
    public boolean addEdge(Edge edge){
        Connection con = null;                          //create variable of connection
        try {
            con = db.getConnection();
            String sql = "INSERT INTO edgelist(aid,bid,transport,time) VALUES (?,?,?,?)"; //sql command that create locality in our table
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, edge.getAID());
            st.setInt(2, edge.getBID());
            st.setString(3, edge.getTransport());
            st.setInt(4, edge.getTime());
>>>>>>> Manas
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
<<<<<<< HEAD
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
=======
    public List <Edge> getAllEdges(){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT aid,bid,transport,time FROM edgelist";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Edge> edges = new LinkedList<>();
            while (rs.next()) {
                Edge edge = new Edge(rs.getInt("aid"),
                        rs.getInt("bid"),
                        rs.getString("transport"),
                        rs.getInt("time"));

                edges.add(edge);
            }

            return edges;
>>>>>>> Manas
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
    public City getCityByName(String name){
        List <City> list = getCityByAtribute("name", name);
        return list.get(0);
    }

    @Override
<<<<<<< HEAD
    public List<City> getAllCities() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,headcount,region,x,y FROM citylist";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
=======
    public int getIDbyName(String name){
        List <City> list = getCityByAttribute("name", name);
        return list.get(0).getId();
    }

    @Override
    public int ShortestPath(String a, String b){
        int s = getIDbyName(a), t = getIDbyName(b);
        int[][] g = new int[100][100];
        int[] d = new int[100];
        Boolean[] u = new Boolean[100];
        for(int i = 0;i < 100; ++ i){
            for(int j = 0;j < 100; ++ j){
                g[i][j] = 10000;
            }
            u[i] = false;
            d[i] = 10000;
        }
        d[s] = 0;
        List <Edge> list = getAllEdges();
        for (int i = 0; i < list.size(); i++) {
            g[list.get(i).getAID()][list.get(i).getBID()] = list.get(i).getTime();
            g[list.get(i).getBID()][list.get(i).getAID()] = list.get(i).getTime();
        }
        while(true){
            int v = 0, mn = 10000;
            for(int i = 0;i < 100; ++ i){
                if(u[i] == false){
                    if(mn > d[i]){
                        mn = d[i];
                        v = i;
                    }
                }
            }
            if(mn == 10000)break;
            u[v] = true;
            for(int i = 0;i < 100; ++ i){
                d[i] = Math.min(d[i], mn + g[v][i]);
            }
        }
        return d[t];
    }

    @Override
    public boolean createCity(IndustrialCity locality) {
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
    public List<City> getCityByAttribute(String attribute_name, String atribute) {
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
>>>>>>> Manas
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
<<<<<<< HEAD
            String sql = "SELECT id FROM citylist WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,name);
=======
            String sql = "SELECT id,name,headcount,region,x,y,product,amount FROM citylist WHERE amount>0";
            Statement st = con.createStatement();
>>>>>>> Manas

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