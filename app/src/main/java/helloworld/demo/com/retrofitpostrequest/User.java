package helloworld.demo.com.retrofitpostrequest;

public class User {


    private String name;

    private String mail;

    private String password;

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
