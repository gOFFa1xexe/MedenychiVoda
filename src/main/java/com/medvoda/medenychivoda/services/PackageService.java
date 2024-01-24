package com.medvoda.medenychivoda.services;

import com.medvoda.medenychivoda.BottleEntity.CarbonationLevel;
import com.medvoda.medenychivoda.BottleEntity.Packages;
import com.medvoda.medenychivoda.repositories.PackageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {
    private final PackageRepository packageRepository;
    @Autowired
    public PackageService(PackageRepository packageRepository){
        this.packageRepository=packageRepository;
    }

    public int getPackageCountByCarbonationLevel(CarbonationLevel carbonationLevel){
        return packageRepository.countByCarbonationLevel(carbonationLevel);
    }

    @Transactional
    public void addPackage(CarbonationLevel carbonationLevel, int quantity) {


        for(int i =1;i<=quantity;i++) {
            Packages newPackage=new Packages();
            newPackage.setCarbonationLevel(carbonationLevel);
            packageRepository.save(newPackage);
        }
    }

}
