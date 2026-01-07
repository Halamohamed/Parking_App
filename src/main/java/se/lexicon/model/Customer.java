package se.lexicon.model;

import java.util.Objects;

public class Customer {
    // Fields
    private Integer id;
    private String name;
    private String phoneNumber;
    private String vehiclePlateNumber;

    public Customer(Integer id, String name, String phoneNumber, String vehiclePlateNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setId(Integer id) {
        Objects.requireNonNull(id, "Id cannot be null");
        this.id = id;
    }

    public void setName(String name) {
        // todo: add validation
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        // todo: add validation - recommendation is to use PATTERN or regex
        this.phoneNumber = phoneNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        // todo: add validation - recommendation is to use PATTERN or regex
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                '}';
    }
}
