package com.medvoda.medenychivoda.repositories;

import com.medvoda.medenychivoda.BottleEntity.CarbonationLevel;
import com.medvoda.medenychivoda.BottleEntity.PackageCapacity;
import com.medvoda.medenychivoda.BottleEntity.Packages;
import com.medvoda.medenychivoda.services.PackageService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface PackageRepository  extends JpaRepository<Packages,Long> {
    int countByCarbonationLevelAndPackageCapacity(CarbonationLevel carbonationLevel, PackageCapacity packageCapacity);

    void save(Package packageEntity);

    int countByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel carbonationLevel,
                                                                   PackageCapacity packageCapacity,
                                                                   LocalDateTime today);

    int countByPackageCapacityAndCreatedAtAfter(PackageCapacity packageCapacity, LocalDateTime today);

    List<Packages> findAllByPackageCapacity(PackageCapacity packageCapacity);



}


