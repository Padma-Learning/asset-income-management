package com.example.asset_income_management.controller;

import com.example.asset_income_management.dto.AssetRequest;
import com.example.asset_income_management.dto.AssetResponse;
import com.example.asset_income_management.entity.AssetType;
import com.example.asset_income_management.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;
//Constructor Injection
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    //1. Create a new asset
    @PostMapping
    public ResponseEntity<AssetResponse> createAsset(@Valid @RequestBody AssetRequest request){

        AssetResponse response=assetService.createAsset(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }
    //2.Get all assets
    @GetMapping
    public ResponseEntity<List<AssetResponse>> getAllAssets(){
        List<AssetResponse> assets=assetService.getAllAssets();
        return ResponseEntity.ok(assets);
    }
    //3. Get an asset by ID
    @GetMapping("/{id}")
    public ResponseEntity<AssetResponse> updateAsset(@PathVariable Long id){
        AssetResponse response=assetService.getAssetById(id);
        return ResponseEntity.ok(response);
    }
    //4.Update an existing asset
    @PutMapping("{id}")
    public ResponseEntity<AssetResponse> updateAsset(@PathVariable Long id, @Valid @RequestBody AssetRequest request){
        AssetResponse response=assetService.updateAsset(id,request);
        return ResponseEntity.ok(response);
    }
    //6.Delete an asset
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id){
        assetService.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }
    //7. Get assets by type
    @GetMapping("/type/{assetType}")
    public ResponseEntity<List<AssetResponse>> getAssetsByType(@PathVariable AssetType assetType){
        List<AssetResponse> assets=assetService.getAssetsByType(assetType);
        return ResponseEntity.ok(assets);
    }
}
