package com.medvoda.medenychivoda.BottleEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ligtly_carbonated_bottle")
public class LightlyCarbonatedBottle extends Bottle {
    public LightlyCarbonatedBottle( double volume) {
        super(CarbonationLevel.LIGHT, volume);
    }

    public LightlyCarbonatedBottle() {

    }
}
