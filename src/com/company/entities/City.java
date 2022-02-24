package com.company.entities;

public class City{
    private int id, headcount;                                 //
    private String name, region;                            //CREATE CLASS LOCALITY
    private double x, y;
    public City() {

    }

    public City(int id, String name,int headcount, String region, double x, double y) {
        setId(id);
        setName(name);
        setHeadcount(headcount);
        setRegion(region);
        setX(x);
        setY(y);
    }

    public double absDistance(City a){
        return Math.sqrt(Math.pow(x - a.getX(), 2) + Math.pow(y - a.getY(), 2)) * Math.PI / 180 * 6371;
    }

    public void setHeadcount(int headcount) {this.headcount = headcount;}
    public int getHeadcount() {return headcount;}

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
    public String getRegion(){return region;}
    public void setRegion(String region){this.region=region;}


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +              //for entering of our classes
                ", headcount='" + headcount + '\'' +
                ", region=" + region + '\'' +
                '}';
    }
}
