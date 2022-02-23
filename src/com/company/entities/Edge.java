package com.company.entities;

public class Edge {
    private int aID, bID, time;
    private String transport;

    public Edge(){

    }

    public Edge(int a, int b, int time, String transport){
        setaID(a);
        setbID(b);
        setTime(time);
        setTransport(transport);
    }

    public void setaID(int aID) {this.aID = aID;}
    public int getaID() {return aID;}

    public void setbID(int bID) {this.bID = bID;}
    public int getbID() {return bID;}

    public void setTime(int time) {this.time = time;}
    public int getTime() {return time;}

    public void setTransport(String transport) {this.transport = transport;}
    public String getTransport() {return transport;}


}
