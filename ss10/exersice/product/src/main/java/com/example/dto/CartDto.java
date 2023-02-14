package com.example.dto;

import com.example.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> productMap = new HashMap<>();
    public CartDto() {

    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto){
        if(productMap.containsKey(productDto)){
            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto,currentValue + 1);
        }else {
            productMap.put(productDto,1);
        }
    }
    
    public void delete(int productId){
        ProductDto productDto = findById(productId);
        if(productMap.containsKey(productDto)){
            productMap.remove(productDto);
        }
    }
    
    private ProductDto findById (int productId){
        for (Map.Entry<ProductDto,Integer> entry : productMap.entrySet()){
            if(entry.getKey().getId() == (productId)){
                return entry.getKey();
            }
        }
        return null;
    }

    public double countTotalPayment(){
        double payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }

    public void decreaseValue(int id,int value){
        ProductDto productDto = findById(id);
        int newValue = value -1;
        productMap.put(productDto,newValue);
    }

    public void increase(int id,int value){
        ProductDto productDto = findById(id);
        int newValue = value + 1;
        productMap.put(productDto,newValue);
    }
}
