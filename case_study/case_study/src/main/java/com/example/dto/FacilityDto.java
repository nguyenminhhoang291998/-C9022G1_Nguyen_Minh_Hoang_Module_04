package com.example.dto;

import com.example.model.FacilityType;
import com.example.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    //2.	Tên dịch vụ được phép chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa.
    //Số tầng phải là số nguyên dương.
    //8.	Lương, Giá, Tiền đặt cọc phải là số dương.

    private int id;
    @Pattern(regexp = "^[A-Z][a-z0-9\\s]*$", message = "Tên không đúng định dạng")
    private String name;

    private int area;
    //    @Pattern(regexp = "^\\d*\\.?\\d+$", message = "Tiền phải là số dương.")
    private String cost;

    private int maxPeople;

    private RentType rentType;

    private FacilityType facilityType;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private double poolArea;

    @Min(value = 1, message = "Số tầng phải là số nguyên dương.")
    private int numberOfFloors;

    private String facilityFree;

    public FacilityDto() {
    }

    public FacilityDto(int id, String name, int area, String cost, int maxPeople, RentType rentType, FacilityType facilityType, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        try {
             double cost = Double.parseDouble(facilityDto.getCost());
            if (cost <= 0) {
                errors.rejectValue("cost", "costError");
            }
        } catch (NumberFormatException e) {
            errors.rejectValue("cost", "costError");
        }
    }
}
