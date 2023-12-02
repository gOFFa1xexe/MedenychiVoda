package Entity;

import Entity.BottleEntity.Bottle;
import Entity.BottleEntity.CarbonationLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "package")
public class Package {

   @Column(name="number_of_bottles",nullable = false)
    private int numberOfBottles;
    @Column(name="quantity",nullable = false)
    private int quantity;
    @Column(name="carbonationLevel",nullable = false)
    private CarbonationLevel carbonationLevel;

    @Column(name = "package_id",nullable = false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    public Package(int numberOfBottles, int quantity, Bottle bottle) {
        this.carbonationLevel=bottle.getCarbonationLevel();
        this.numberOfBottles = numberOfBottles;
        this.quantity=quantity;
    }

    public Package() {

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
