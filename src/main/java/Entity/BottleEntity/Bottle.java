package Entity.BottleEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


public class Bottle {

    private CarbonationLevel carbonationLevel;
    private double volume;


    public Bottle(CarbonationLevel carbonatedLevel, double volume) {
        this.volume = volume;
    }

    public CarbonationLevel getCarbonationLevel() {
        return carbonationLevel;
    }

    public double getVolume() {
        return volume;
    }
}

