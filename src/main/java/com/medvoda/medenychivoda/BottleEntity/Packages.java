package com.medvoda.medenychivoda.BottleEntity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Entity
@Table(name = "packages")
public class Packages {
    @Column(name = "package_id",nullable = false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

   @Enumerated(EnumType.STRING)
    @Column(name="capacity",nullable = false)
    private PackageCapacity packageCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name="carbonationLevel",nullable = false)
    private CarbonationLevel carbonationLevel;


    @Column(name = "creation_time")
    @CreationTimestamp
    private LocalDateTime createdAt;



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PackageCapacity getPackageCapacity() {
        return packageCapacity;
    }

    public void setPackageCapacity(PackageCapacity packageCapacity) {
        this.packageCapacity = packageCapacity;
    }

    public Packages(PackageCapacity packageCapacity, CarbonationLevel carbonationLevel) {
        this.carbonationLevel=carbonationLevel;

        this.packageCapacity=packageCapacity;
    }

    public Packages() {

    }

    public void setCarbonationLevel(CarbonationLevel carbonationLevel) {
        this.carbonationLevel = carbonationLevel;
    }


    public Long getId() {
        return id;
    }



    public CarbonationLevel getCarbonationLevel() {
        return carbonationLevel;
    }


}
