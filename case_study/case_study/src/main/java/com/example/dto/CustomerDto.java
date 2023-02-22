package com.example.dto;

import com.example.model.CustomerType;

import javax.validation.constraints.Pattern;

public class CustomerDto {
    private int id;

    private CustomerType customerType;
    @Pattern(regexp = "^[A-Z]\\p{L}+(\\s[A-Z]\\p{L}*)+$", message = "Tên không được chứa số, các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;

    private String dayOfBirth;

    private boolean gender;
    @Pattern(regexp = "^\\d{9}(\\d{3})?$", message = "Số CMND phải là 9 hoặc 12 số.")
    private String idCard;

    @Pattern(regexp = "^([(]84[)][+])?09[0-1]\\d{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phoneNumber;

    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+$", message = "Email chưa đúng định dạng.")
    private String email;

    private String address;

    public CustomerDto() {
    }

    public CustomerDto(int id,CustomerType customerType, String name, String dayOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
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
}
