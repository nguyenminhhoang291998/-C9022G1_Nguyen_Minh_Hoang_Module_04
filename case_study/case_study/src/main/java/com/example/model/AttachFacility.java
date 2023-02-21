package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(45)")
    private  String name;

    private double cost;

    @Column(columnDefinition = "varchar(10)")
    private String unit;

    @Column(columnDefinition = "varchar(45)")
    private String status;

    @JsonIgnore
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetailSet;

    public AttachFacility() {
    }

    public AttachFacility(int id, String name, double cost,
                          String unit, String status, Set<ContractDetail> contractDetailSet) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetailSet = contractDetailSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
