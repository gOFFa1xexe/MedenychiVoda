package com.medvoda.medenychivoda.BottleEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "non_carbonated_bottle")
public class NonCarbonatedBottle extends Bottle {
    public NonCarbonatedBottle(double volume) {
        super(CarbonationLevel.NONE,volume);
    }

    public NonCarbonatedBottle() {

    }
}
