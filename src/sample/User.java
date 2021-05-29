package sample;

public  class User {
    private String fullname;
    private String phonenumber;
    private String login;
    private String password;

    public User(String fullname, String phonenumber, String login, String password) {
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.login = login;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
