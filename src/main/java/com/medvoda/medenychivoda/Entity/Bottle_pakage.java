package com.medvoda.medenychivoda.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bottle_pakage")
public class Bottle_pakage {

    @Column(name = "id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "volume")
    private Volume volume = Volume.HALF_LITER;
    @Column(name = "sparkle")
    boolean SPARKLED = false;
    @Column(name = "amount")
    private long amount;
}

