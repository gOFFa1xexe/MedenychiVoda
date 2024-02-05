package com.medvoda.medenychivoda.repositories;

import com.medvoda.medenychivoda.Entity.PackageEntity.CarbonationLevel;
import com.medvoda.medenychivoda.Entity.PackageEntity.PackageCapacity;
import com.medvoda.medenychivoda.Entity.PackageEntity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PackageRepository  extends JpaRepository<Packages,Long> {
    int countByCarbonationLevelAndPackageCapacity(CarbonationLevel carbonationLevel, PackageCapacity packageCapacity);
    void save(Package packageEntity);

    int countByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(CarbonationLevel carbonationLevel,
                                                                   PackageCapacity packageCapacity,
                                                                   LocalDateTime today);
    int countByPackageCapacityAndCreatedAtAfter(PackageCapacity packageCapacity,LocalDateTime today);
    Packages findByCarbonationLevel(CarbonationLevel carbonationLevel);
    List<Packages> getAllByCarbonationLevelAndPackageCapacityAndCreatedAtAfter(
            CarbonationLevel carbonationLevel, PackageCapacity packageCapacity, LocalDateTime today);

}

