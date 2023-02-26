package com.example.dto;


import com.example.model.Customer;
import com.example.model.Employee;
import com.example.model.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Set;


public class ContractDto implements Validator {
    private String startDate;

    private String endDate;
    @Min(value = 0,message = "Tiền đặt cọc phải là số dương.")
    private double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;


    public ContractDto() {
    }

    public ContractDto( String startDate, String endDate,
                       double deposit, Employee employee,
                       Customer customer, Facility facility
                     ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (contractDto.getStartDate().isEmpty() || contractDto.getEndDate().isEmpty()) {
            if (contractDto.getStartDate().isEmpty()) {
                errors.rejectValue("startDate", "dateEmptyError");
            }
            if (contractDto.getEndDate().isEmpty()) {
                errors.rejectValue("endDate", "dateEmptyError");
            }
            return;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(contractDto.getStartDate(), dateTimeFormatter);
        LocalDate endDate = LocalDate.parse(contractDto.getEndDate(), dateTimeFormatter);
        if (startDate.isAfter(endDate)) {
            errors.reject("dateError");
        }
    }
}
