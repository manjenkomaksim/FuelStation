package sample;

public class Client extends User{
    private String cardnumber;
    private String fuel;

    public Client(String fullname, String phonenumber, String cardnumber, String fuel, String login, String password) {
        super(fullname, phonenumber, login, password);
        this.cardnumber = cardnumber;
        this.fuel = fuel;
    }

    public Client() {
        super();
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
