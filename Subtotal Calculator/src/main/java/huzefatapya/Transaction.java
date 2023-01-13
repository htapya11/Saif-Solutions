package huzefatapya;


public class Transaction {
    private String date;
    private String purchase;
    private double cost;

    public Transaction (String date, String purchase, double cost){
        this.date = date;
        this.purchase = purchase;
        this.cost = cost;
    }

    public Transaction (String purchase, double cost){
        this.purchase = purchase;
        this.cost = cost;
    }

    public String getDate(){
        return this.date;
    }

    public String getPurchase() {
        return this.purchase;
    }

    public double getCost(){
        return this.cost;
    }

    public double increaseCost(double value){
        return this.cost + value;
    }

    public String toString(){
        return "Date: " + this.date + " " + "Purchase: " + this.purchase + " " + "Cost: " + this.cost;
    }
}

