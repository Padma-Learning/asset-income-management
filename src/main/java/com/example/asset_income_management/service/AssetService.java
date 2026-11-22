package com.example.asset_income_management.service;

import com.example.asset_income_management.dto.AssetRequest;
import com.example.asset_income_management.dto.AssetResponse;
import com.example.asset_income_management.entity.Asset;
import com.example.asset_income_management.entity.AssetType;
import com.example.asset_income_management.repository.AssetRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository){
        this.assetRepository=assetRepository;
    }

    //1. Create a new asset
    public AssetResponse createAsset(AssetRequest request){
        Asset asset=new Asset();
        asset.setAssetName(request.getAssetName());
        asset.setAssetType(request.getAssetType());
        asset.setPurchaseValue(request.getPurchaseValue());
        asset.setCurrentValue(request.getCurrentValue());
        asset.setDescription(request.getDescription());

        Asset savedAsset=assetRepository.save(asset);
        return convertToResponse(savedAsset);

    }
    //2.Get all assets
    @Transactional(readOnly=true)
    public List<AssetResponse> getAllAssets(){
        return assetRepository.findAll()
                .stream().
                map(this::convertToResponse).
                toList();
    }
    //3.Get asset by ID
@Transactional(readOnly = true)
public AssetResponse getAssetById(Long id){
        Asset asset=assetRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Asset not found with ID: " +id));
        return convertToResponse(asset);
}
//4. Update an existing asset
    public AssetResponse updateAsset(Long id, AssetRequest request){
        Asset asset=assetRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Asset not found with ID: " +id));
        asset.setAssetName(request.getAssetName());
        asset.setAssetType(request.getAssetType());
        asset.setPurchaseValue(request.getPurchaseValue());
        asset.setCurrentValue(request.getCurrentValue());
        asset.setPurchaseDate(request.getPurchaseDate());
        asset.setDescription(request.getDescription());

        Asset updateAsset=assetRepository.save(asset);
        return convertToResponse(updateAsset);
    }
    //5. Update only the current value
    public AssetResponse updateCurrentValue(Long id, BigDecimal newValue){

        Asset asset=assetRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Asset not found with ID: " +id));
        asset.setCurrentValue(newValue);
        Asset updatedAsset=assetRepository.save(asset);
        return convertToResponse(updatedAsset);
    }
    //6. Delete an asset
    public void deleteAsset(Long id){
        Asset asset=assetRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Asset not found with ID: " +id));
        assetRepository.delete(asset);
    }

    //7. Find assets by type
    @Transactional(readOnly = true)
    public List<AssetResponse> getAssetsByType(AssetType assetType){
        return assetRepository.findByAssetType(assetType)
                .stream()
                .map(this::convertToResponse).
                toList();
    }

//Convert Asset entity into AssetResponse DTO
    private AssetResponse convertToResponse(Asset asset){
        AssetResponse assetResponse=new AssetResponse();
        assetResponse.setId(asset.getId());
        assetResponse.setAssetName(asset.getAssetName());
        assetResponse.setAssetType((asset.getAssetType()));
        assetResponse.setPurchaseValue(asset.getPurchaseValue());
        assetResponse.setCurrentValue(asset.getCurrentValue());

        BigDecimal appreciation=asset.getCurrentValue().subtract(asset.getPurchaseValue());
        assetResponse.setAppreciation(appreciation);
        assetResponse.setPurchaseDate(asset.getPurchaseDate());
        assetResponse.setDescription((asset.getDescription()));
        return assetResponse;

    }
}
