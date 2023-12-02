package com.medvoda.medenychivoda.BottleEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "carbonated_bottle")
public class CarbonatedBottle extends Bottle {

    public CarbonatedBottle(double volume) {
        super(CarbonationLevel.STRONG, volume);
    }

    public CarbonatedBottle() {

    }
}
