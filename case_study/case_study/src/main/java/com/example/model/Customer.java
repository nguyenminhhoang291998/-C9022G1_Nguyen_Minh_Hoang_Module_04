package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "customer_type_id",referencedColumnName = "id")
    private CustomerType customerType;

    @Column(columnDefinition = "varchar(45)")
    private String name;

    @Column(columnDefinition = "date")
    private String dayOfBirth;

    private boolean gender;

    @NotNull
    @Column(columnDefinition = "varchar(45)",unique = true)
    private String idCard;

    @NotNull
    @Column(columnDefinition = "varchar(45)",unique = true)
    private String phoneNumber;

    @NotNull
    @Column(columnDefinition = "varchar(45)",unique = true)
    private String email;

    @Column(columnDefinition = "varchar(45)")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet;

    private boolean flag;

    public Customer() {
    }

    public Customer(int id, CustomerType customerType, String name,
                    String dayOfBirth, boolean gender, String idCard,
                    String phoneNumber, String email, String address,
                    Set<Contract> contractSet, boolean flag) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;

        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.contractSet = contractSet;
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
