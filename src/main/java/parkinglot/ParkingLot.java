package parkinglot;

import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    private final Set<Car> cars = new HashSet<>();
    private final int capacity;
    private final Owner owner;


    public ParkingLot(int capacity, Owner owner) {
        this.capacity = capacity;
        this.owner = owner;
    }

    public boolean accept(Car car) {
        return isUsageBelow80Percent() && park(car);
    }

    private boolean park(Car car) {
        cars.add(car);
        notifyCapacity();
        return true;
    }

    private void notifyCapacity() {
        if (isUsageOver75Percent()) { owner.usageOver75Percent(this); }
    }

    private boolean isUsageBelow80Percent() {
        return usagePercentage() < 0.8;
    }

    private boolean isUsageOver75Percent() {
        return usagePercentage() > 0.75;
    }

    private double usagePercentage() {
        return (double) cars.size() / capacity;
    }

    public boolean remove(Car car) {
        return cars.remove(car);
    }

}
