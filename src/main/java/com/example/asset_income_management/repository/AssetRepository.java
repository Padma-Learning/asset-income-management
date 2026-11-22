package com.example.asset_income_management.repository;

import com.example.asset_income_management.entity.Asset;
import com.example.asset_income_management.entity.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AssetRepository extends JpaRepository<Asset,Long> {
    //Find assets by asset type
    List<Asset> findByAssetType(AssetType assetType);

    //Find assets by name
    List<Asset> findByAssetName(String assetName);

}
