package com.company.entities;

public class IndustrialCity extends City{
    private String product;
    private int amount;
    public IndustrialCity(){
        super();
    }

    public IndustrialCity(int id, String name,int m_amount,int w_amount, String region, int x, int y, String product, int amount) {
        super(id, name, m_amount, w_amount, region, x, y);
    }

    public String getProduct() {return product;}
    public void setProduct(String product) {this.product = product;}

    public int getAmount() {return amount;}
    public void setAmount(int amount) {this.amount = amount;}

    @Override
    public String toString() {
        return "IndustrialCity{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +              //for entering of our classes
                ", headcount='" + super.headcount() + '\'' +
                ", region=" + super.getRegion() + '\'' +
                '}';
    }
}
