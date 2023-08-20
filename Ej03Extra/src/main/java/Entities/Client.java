package Entities;
/*Besides the requested attributes, boolean active was added in order to make a logical delete
without compromising database registers.*/
public class Client {

    private String name;
    private String dni;
    private String email;
    private long phone;
    private String address;
    private boolean active;

    public Client() {
    }

    public Client(String dni, String name, String email, long phone, String address) {
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", active=" + active +
                '}';
    }
}
