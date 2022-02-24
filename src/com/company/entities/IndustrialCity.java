package com.company.entities;

public class IndustrialCity extends City{
    private String product;
    private int amount;
    public IndustrialCity(){
        super();
        setProduct("Nothing");
        setAmount(0);
    }

    public IndustrialCity(int id, String name, int headcount, String region, double x, double y, String product, int amount) {
        super(id, name, headcount, region, x, y);
        setProduct(product);
        setAmount(amount);
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
                ", headcount=" + super.getHeadcount() + '\'' +
                ", region='" + super.getRegion() + '\'' +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                '}';
    }
}
