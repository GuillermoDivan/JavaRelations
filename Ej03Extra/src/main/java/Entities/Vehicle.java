package Entities;

public class Vehicle {
    private String licensePlate;
    private String brand;
    private String model;
    private int year;
    private String engineNumber; //Incluye letras...
    private String chassis; // Supuestamente hay 3 tipos posibles. Podría ser enum.
    private String color;
    private String type; // Podría ser enum.
    private boolean active;

    public Vehicle() {
    }

    public Vehicle(String licensePlate, String brand, String model, int year, String engineNumber, String chassis, String color, String type) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineNumber = engineNumber;
        this.chassis = chassis;
        this.color = color;
        this.type = type;
        this.active = true;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engineNumber='" + engineNumber + '\'' +
                ", chassis='" + chassis + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", active=" + active +
                '}';
    }
}

/*b. Gestión de vehículos. Se registra la información de cada vehículo asegurado. Marca,
modelo, año, número de motor, chasis, color, tipo (camioneta, sedán, etc.).*/