package sample;

public class Fuel{
    private String typeOfFuel;
    private String price;
    private String amount;

    public Fuel(String typeOfFuel, String price, String amount){
        this.typeOfFuel = typeOfFuel;
        this.price = price;
        this.amount = amount;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
