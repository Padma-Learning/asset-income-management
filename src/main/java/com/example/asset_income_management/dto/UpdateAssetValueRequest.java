package com.example.asset_income_management.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class UpdateAssetValueRequest {

    @NotNull(message = "Current value ie required")
    //prevents the request from omitting the value
    @DecimalMin(value = "0.00", message="Current value cannot be negative")
    //currentValue holds the new market value;
    private BigDecimal currentValue;

    public UpdateAssetValueRequest(){

    }
    //getter ans setter allow Spring to read the JSON request and populate th java object
    public BigDecimal getCurrentValue(){
        return currentValue;
    }
    public void setCurrentValue(BigDecimal currentValue){
        this.currentValue=currentValue;
    }
}
