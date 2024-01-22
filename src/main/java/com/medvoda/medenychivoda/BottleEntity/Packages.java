package com.medvoda.medenychivoda.BottleEntity;

import jakarta.persistence.*;


@Entity
@Table(name = "packages")
public class Packages {
    @Column(name = "package_id",nullable = false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
   @Column(name="number_of_bottles",nullable = false)
    private int numberOfBottles;
    @Column(name="quantity",nullable = false)
    private int quantity;
    @Enumerated(EnumType.STRING)
    @Column(name="carbonationLevel",nullable = false)
    private CarbonationLevel carbonationLevel;

    



    public Packages(int numberOfBottles, int quantity, Bottle bottle) {
        this.carbonationLevel=bottle.getCarbonationLevel();
        this.numberOfBottles = numberOfBottles;
        this.quantity=quantity;
    }

    public Packages() {

    }

    public int getNumberOfBottles() {
        return numberOfBottles;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public CarbonationLevel getCarbonationLevel() {
        return carbonationLevel;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
