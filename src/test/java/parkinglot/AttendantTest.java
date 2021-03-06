package parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttendantTest {

    @Test
    void shouldParkACarInALotWithSpots() {
        Attendant attendant = new Attendant(new ParkingLot(1, new Owner()));
        Car car = new Car();

        assertTrue(attendant.park(car));
    }

    @Test
    void shouldParkTheCarWhenMultipleParkingLotsHaveSpots() {
        Attendant attendant = new Attendant(new ParkingLot(0, new Owner()),
                new ParkingLot(4, new Owner()));

        Car car = new Car();

        assertTrue(attendant.park(car));
    }

    @Test
    void shouldNotParkTheCarWhenThereIsNoSpaceInDifferentLots() {
        Attendant attendant = new Attendant(new ParkingLot(0, new Owner()),
                new ParkingLot(0, null));
        Car car = new Car();

        assertFalse(attendant.park(car));
    }


}
