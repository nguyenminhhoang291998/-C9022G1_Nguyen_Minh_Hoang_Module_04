package com.example.form.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    @NotEmpty(message = "Không được để trống")
    @Size(min = 5,max = 45)
    private String firstName;
    @NotEmpty(message = "Không được để trống")
    @Size(min = 5,max = 45)
    private String lastName;

    private String phoneNumber;
    @Min(value = 18,message = "Tuổi phải lớn hơn 18")
    private int age;
    @Email(message = "email không hợp lệ")
    private String email;

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phoneNumber = userDto.getPhoneNumber();
        if(phoneNumber.length()!=10){
            errors.rejectValue("phoneNumber","phoneError1");
        }else if(!phoneNumber.matches("^[0-9]+$")){
            errors.rejectValue("phoneNumber","phoneError2");
        }
    }
}
