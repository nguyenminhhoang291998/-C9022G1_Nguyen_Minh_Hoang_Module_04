package com.example.dto;

import com.example.model.ContractDetail;
import com.example.model.Customer;
import com.example.model.Employee;
import com.example.model.Facility;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Set;


public class ContractDto {

    private int id;

    private String startDate;

    private String endDate;
    @Min(value = 0,message = "Tiền đặt cọc phải là số dương.")
    private double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;



    public ContractDto() {
    }

    public ContractDto(int id, String startDate, String endDate,
                       double deposit, Employee employee,
                       Customer customer, Facility facility
                     ) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

}
