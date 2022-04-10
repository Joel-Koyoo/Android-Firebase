package com.jovanovic.stefan.sqlitetutorial;

public class product {
    private String product_name;
    private String Quantity;
    private  int price;

    public product(String product_name, String Quantity, int price) {
        this.product_name = product_name;
        this.Quantity = Quantity;
        this.price = price;

    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getquantity() {
        return Quantity;
    }

    public void setquantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }
}
