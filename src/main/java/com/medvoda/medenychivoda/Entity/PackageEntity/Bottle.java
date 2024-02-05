/*
package com.medvoda.medenychivoda.Entity.PackageEntity;

import jakarta.persistence.*;


@Entity
@Table(name = "bottle")
public class Bottle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "carbonation_level")
    private CarbonationLevel carbonationLevel;

    @Column(name = "volume")
    private double volume;


    public void setCarbonationLevel(CarbonationLevel carbonationLevel) {
        this.carbonationLevel = carbonationLevel;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Bottle(CarbonationLevel carbonatedLevel, double volume) {
        this.volume = volume;
    }

    public Bottle() {

    }

    public CarbonationLevel getCarbonationLevel() {
        return carbonationLevel;
    }

    public double getVolume() {
        return volume;
    }
}

*/
