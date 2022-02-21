package com.company.entities;

public class Locality {
    private int id;                                 //
    private String name;                            //CREATE CLASS LOCALITY
    private int m_amount;                           //
    private int w_amount;
    private String region;

    public Locality() {

    }

    public Locality(String name, int m_amount,int w_amount, String region) {
        setName(name);
        setM_amount(m_amount);
        setW_amount(w_amount);
        setRegion(region);
    }

    public Locality(int id, String name,int m_amount,int w_amount, String region ) {
        setId(id);
        setName(name);
        setM_amount(m_amount);
        setW_amount(w_amount);
        setRegion(region);
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName(){return name;}                                   //
    public void setName(String name) {this.name = name;}                    //
                                                                            //
    public int getM_amount() {
        return m_amount;
    }                           //CREATE getters and setters
    public void setM_amount(int m_amount) {
        this.m_amount = m_amount;
    }     //
                                                                            //
    public int getW_amount(){return w_amount;}                              //
    public void setW_amount(int w_amount) {
        this.w_amount = w_amount;
    }

    public String getRegion(){return region;}
    public void setRegion(String region){this.region=region;}


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +              //for entering of our classes
                ", surname='" + m_amount + '\'' +
                ", gender=" + w_amount +'\''+
                '}';
    }
}
