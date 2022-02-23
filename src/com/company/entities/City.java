package com.company.entities;

public class City{
    private int id;                                 //
    private String name;                            //CREATE CLASS LOCALITY
    private int m_amount;                           //
    private int w_amount;
    private String region;
    private double x, y;
    public City() {

    }

    public City(int id, String name,int m_amount,int w_amount, String region, int x, int y) {
        setId(id);
        setName(name);
        setM_amount(m_amount);
        setW_amount(w_amount);
        setRegion(region);
        setX(x);
        setY(y);
    }

    public int headcount(){
        return getM_amount() + getW_amount();
    }

    public double m_percent(){
        return ((double)getM_amount() / headcount()) * 100;
    }

    public double w_percent(){
        return ((double)getW_amount() / headcount()) * 100;
    }

    public double absDistance(City a){
        return Math.sqrt(Math.pow(x - a.getX(), 2) + Math.pow(y - a.getY(), 2)) * Math.PI / 180 * 6371;
    }

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}

    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

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
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +              //for entering of our classes
                ", headcount='" + headcount() + '\'' +
                ", region=" + region + '\'' +
                '}';
    }
}
