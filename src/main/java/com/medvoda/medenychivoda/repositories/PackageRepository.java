package com.medvoda.medenychivoda.repositories;

import com.medvoda.medenychivoda.BottleEntity.CarbonationLevel;
import com.medvoda.medenychivoda.BottleEntity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository  extends JpaRepository<Packages,Long> {
    int countByCarbonationLevel(CarbonationLevel carbonationLevel);
    void save(Package packageEntity);

    Packages findByCarbonationLevel(CarbonationLevel carbonationLevel);
}
