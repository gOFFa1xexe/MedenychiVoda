package com.medvoda.medenychivoda.services;

import com.medvoda.medenychivoda.Entity.PackageEntity.CarbonationLevel;
import com.medvoda.medenychivoda.Entity.PackageEntity.PackageCapacity;
import com.medvoda.medenychivoda.Entity.PackageEntity.Packages;
import com.medvoda.medenychivoda.repositories.PackageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class PackageService {
    private final PackageRepository packageRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository){
        this.packageRepository=packageRepository;
    }

    public int getPackageCountByCarbonationLevelAndCapacity(CarbonationLevel carbonationLevel, PackageCapacity packageCapacity){
        return packageRepository.countByCarbonationLevelAndPackageCapacity(carbonationLevel,packageCapacity);
    }

    public List<Packages> getAllPackagesByCarbonationLevelAndCapacityAndCreatedAtAfter(
            CarbonationLevel carbonationLevel, PackageCapacity packageCapacity, LocalDateTime today) {
        return packageRepository.getAllByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                carbonationLevel, packageCapacity, today);
    }

    public int getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel carbonationLevel,
                                                                                    PackageCapacity packageCapacity){
        LocalDateTime today=LocalDateTime.now().toLocalDate().atStartOfDay();
        return packageRepository.countByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(carbonationLevel,packageCapacity,today);
    }
    public int getPackageCountByPackageCapacityAndCreatedAt(PackageCapacity packageCapacity){
        LocalDateTime today=LocalDateTime.now().toLocalDate().atStartOfDay();
        return packageRepository.countByPackageCapacityAndCreatedAtAfter(packageCapacity,today);
    }
    @Transactional
    public void addPackage(CarbonationLevel carbonationLevel, int quantity, PackageCapacity packageCapacity) {

        for(int i =1;i<=quantity;i++) {
            Packages newPackage=new Packages();
            newPackage.setCarbonationLevel(carbonationLevel);
            newPackage.setPackageCapacity(packageCapacity);
            packageRepository.save(newPackage);
        }
    }

}