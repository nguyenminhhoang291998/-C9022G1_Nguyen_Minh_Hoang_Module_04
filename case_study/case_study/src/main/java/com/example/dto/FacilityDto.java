package com.example.dto;

import com.example.model.FacilityType;
import com.example.model.RentType;

import javax.persistence.*;

public class FacilityDto {
    //2.	Tên dịch vụ được phép chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa.
    //Số tầng phải là số nguyên dương.
    //8.	Lương, Giá, Tiền đặt cọc phải là số dương.

    private int id;

    private String name;

    private int area;

    private double cost;

    private int maxPeople;

    private RentType rentType;

    private FacilityType facilityType;

    private String standardRoom;

    private String descriptionOtherConvenience;

    private double poolArea;

    private int numberOfFloors;

    private String facilityFree;
}
