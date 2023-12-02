package Entity.BottleEntity;

public class NonCarbonatedBottle extends Bottle {
    public NonCarbonatedBottle(double volume) {
        super(CarbonationLevel.NONE,volume);
    }
}
