package parkinglot;

import java.util.Arrays;
import java.util.List;


public class Attendant {

    private final List<ParkingLot> parkingLots;
    public Attendant(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public boolean park(Car car) {
        for (ParkingLot lot: parkingLots) {
            if (lot.accept(car)) return true;
        }
        return false;
    }

}
