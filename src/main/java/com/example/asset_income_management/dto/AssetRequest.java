package com.example.asset_income_management.dto;

import com.example.asset_income_management.entity.AssetType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.swing.plaf.basic.BasicIconFactory;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AssetRequest {

    @NotBlank(message = "Asset name is required")
    @Size(max=100, message = "Asset name cannot exceed 100 characters")
    private String assetName;

    @NotNull(message = "Asset type is required")
    private AssetType assetType;

    @NotNull(message = "Purchase value is required")
    @DecimalMin(value ="0.01", message="Purchase value must be greater than zero")
    private BigDecimal purchaseValue;

    @NotNull(message = "Current value is required")
    @DecimalMin(value="0.00",message="Current value cannot be negative")
    private BigDecimal currentValue;

    private LocalDate purchaseDate;

    @Size(max=500, message="Description cannot exceed 500 characters")
    private String description;

    public AssetRequest(){

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
