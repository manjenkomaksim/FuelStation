package sample;

public class Staff extends User{
    private String address;
    private String duty;

    public Staff(String fullname, String phonenumber, String address, String duty, String login, String password) {
        super(fullname, phonenumber, login, password);
        this.address = address;
        this.duty = duty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
