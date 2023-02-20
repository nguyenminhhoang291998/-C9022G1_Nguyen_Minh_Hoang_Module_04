package com.example.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ContractDetailDto {
    @Id
    private int id;

    private String attachFacilityName;
    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(int id, String attachFacilityName, int quantity) {
        this.id = id;
        this.attachFacilityName = attachFacilityName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
