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

   /* public List<Packages> getAllPackagesByCarbonationLevelAndCapacityAndCreatedAtAfter(
            CarbonationLevel carbonationLevel, PackageCapacity packageCapacity, LocalDateTime today) {
        return packageRepository.getAllByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
                carbonationLevel, packageCapacity, today);
    }*/

    public int getPackageCountByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel carbonationLevel,
                                                                                    PackageCapacity packageCapacity){
        LocalDateTime today=LocalDateTime.now().toLocalDate().atStartOfDay();
        return packageRepository.countByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(carbonationLevel,packageCapacity,today);
    }
    public int getPackageToday(PackageCapacity packageCapacity){
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

    public int getPackageCountToday(List<Packages> packagesList,CarbonationLevel carbonationLevel){
        int count=0;
        LocalDateTime today=LocalDateTime.now().toLocalDate().atStartOfDay();
        if(packagesList!=null){
            for(Packages packages:packagesList){
                if(packages.getCreatedAt().isAfter(today)&&packages.getCarbonationLevel()==carbonationLevel){
                    count++;
                }
            }
        }
        return count;
    }
    public int getPackageCountToday(List<Packages> packagesList){
        int count=0;
        LocalDateTime today=LocalDateTime.now().toLocalDate().atStartOfDay();
        if(packagesList!=null){
            for(Packages packages:packagesList){
                if(packages.getCreatedAt().isAfter(today)){
                    count++;
                }
            }
        }
        return count;
    }
    public int getPackageCount(List<Packages> packagesList, CarbonationLevel carbonationLevel) {
       int count=0;
       if(packagesList!=null) {
           for (Packages packages : packagesList) {
               if (packages.getCarbonationLevel() == carbonationLevel) {
                   count++;
               }
           }
       }
       return count;
    }
    public List<Packages> getAllPackagesByCapacity(PackageCapacity packageCapacity) {
        return packageRepository.findAllByPackageCapacity(packageCapacity);
    }

}