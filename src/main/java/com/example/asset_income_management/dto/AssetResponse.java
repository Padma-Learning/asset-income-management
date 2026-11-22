package com.example.asset_income_management.dto;

import com.example.asset_income_management.entity.AssetType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AssetResponse {

    private Long id;
    private String assetName;
    private AssetType assetType;
    private BigDecimal purchaseValue;
    private BigDecimal currentValue;
    private  BigDecimal appreciation;
    private LocalDate purchaseDate;
    private String description;

    public AssetResponse(){

    }

    public BigDecimal getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(BigDecimal appreciation) {
        this.appreciation = appreciation;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(BigDecimal purchaseValue) {
        this.purchaseValue = purchaseValue;
    }
}
