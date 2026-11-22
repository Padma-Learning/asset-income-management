package com.example.asset_income_management.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="Assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false)
    private Long id;

    @Column(name="Asset Name",nullable = false, length = 100)
    private String assetName;

    @Enumerated(EnumType.STRING)
    @Column(name="Type",nullable = false,length = 30)
    private AssetType assetType;

    @Column(name="PurchaseValue",nullable = false,precision = 15,scale = 2)
    private BigDecimal purchaseValue;

    @Column(name="Current Value",nullable = false,precision = 15,scale = 2)
    private BigDecimal currentValue;

    private LocalDate purchaseDate;

    @Column(name="Description",length = 500)
    private String Description;

    //JPA requires a no-argument constructor
    public Asset(){

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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
