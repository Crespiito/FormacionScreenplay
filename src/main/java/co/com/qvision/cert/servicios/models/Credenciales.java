package co.com.qvision.cert.servicios.models;

public class Credenciales {


    private String userName;
    private String password;

    public Credenciales(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
