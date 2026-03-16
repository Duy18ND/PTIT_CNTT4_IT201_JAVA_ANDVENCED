package SESSION07.SESSION07_01;

public class Customer {
    private String Name;
    private String email;
    private String address;

    public Customer(String name, String email, String address) {
        Name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
