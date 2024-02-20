package com.medvoda.medenychivoda.Entity.OrderEntity;


import com.medvoda.medenychivoda.Entity.PackageEntity.CarbonationLevel;
import com.medvoda.medenychivoda.Entity.PackageEntity.PackageCapacity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Entity
@Table( name ="order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(name="capacity",nullable = false)
   /* @NotBlank(message = "Capacity can not be null")*/
    private PackageCapacity packageCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name="carbonationLevel",nullable = false)
    /*@NotBlank(message = "Carbonation level can not be null")*/
    private CarbonationLevel carbonationLevel;

    @Column(name = "package_quantity")
    /*@NotBlank(message = "Package quantity can not be null")*/
    private int packageQuantity;


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CarbonationLevel getCarbonationLevel() {
        return carbonationLevel;
    }

    public void setCarbonationLevel(CarbonationLevel carbonationLevel) {
        this.carbonationLevel = carbonationLevel;
    }

    public int getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(int packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public PackageCapacity getPackageCapacity() {
        return packageCapacity;
    }

    public void setPackageCapacity(PackageCapacity packageCapacity) {
        this.packageCapacity = packageCapacity;
    }
}