package parkinglot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private final Set<Car> cars = new HashSet<>();
    private final int capacity;


    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean accept(Car car) {
        return cars.size() < this.capacity && cars.add(car);
    }

    public boolean remove(Car car) {
        return cars.remove(car);
    }

    public void subscribe(Attendant attendant) {

    }
}
