package com.company.entities;

public class Edge {
    private int aID, bID, time;
    private String transport;

    public Edge(){

    }

    public Edge(int a, int b, String transport, int time){
        setAID(a);
        setBID(b);
        setTime(time);
        setTransport(transport);
    }

    public void setAID(int aID) {this.aID = aID;}
    public int getAID() {return aID;}

    public void setBID(int bID) {this.bID = bID;}
    public int getBID() {return bID;}

    public void setTime(int time) {this.time = time;}
    public int getTime() {return time;}

    public void setTransport(String transport) {this.transport = transport;}
    public String getTransport() {return transport;}


}
