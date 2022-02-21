package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Locality;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(Locality locality) {
        Connection con = null;                          //create variable of connection
        try {
            con = db.getConnection();
            String sql = "INSERT INTO city(name,m_amount,w_amount,region) VALUES (?,?,?,?)"; //sql command that create locality in our table
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, locality.getName());
            st.setInt(2, locality.getM_amount());
            st.setInt(3, locality.getW_amount());
            st.setString(4,locality.getRegion());

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
    public Locality getLocality(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Locality locality = new Locality(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("m_amount"),
                        rs.getInt("w_amount"),
                        rs.getString("region"));

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
    public List<Locality> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Locality> localities = new LinkedList<>();
            while (rs.next()) {
                Locality locality = new Locality(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("m_amount"),
                        rs.getInt("w_amount"),
                        rs.getString("region"));

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