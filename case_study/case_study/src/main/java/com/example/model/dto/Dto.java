package com.example.model.dto;

import com.example.model.ContractDetail;

import javax.persistence.*;
import java.util.List;

@Entity
//@NamedStoredProcedureQuery(name = "contractDto",procedureName = "select_all_contract_dto",
//parameters = {
//       @StoredProcedureParameter(mode = ParameterMode.OUT, name = "id",type = Integer.class),
//       @StoredProcedureParameter(mode = ParameterMode.OUT, name = "facility_name",type = String.class),
//       @StoredProcedureParameter(mode = ParameterMode.OUT, name = "customer_name",type = String.class),
//       @StoredProcedureParameter(mode = ParameterMode.OUT, name = "start_date",type = String.class),
//       @StoredProcedureParameter(mode = ParameterMode.OUT, name = "end_date",type = String.class),
//       @StoredProcedureParameter(mode = ParameterMode.OUT, name = "deposit",type = Double.class),
//       @StoredProcedureParameter(mode = ParameterMode.OUT, name = "total_cost",type = Double.class)
//})
public class Dto {
    @Id
    private int id;
    private String facilityName;
    private String customerName;
    private String startDate;
    private String endDate;
    private double deposit;
    private double totalCost;



    public Dto() {
    }

    public Dto(int id, String facilityName, String customerName, String startDate, String endDate, double deposit, double totalCost) {
        this.id = id;
        this.facilityName = facilityName;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalCost = totalCost;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
