package parkinglot;

import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


public class ParkingLotTest {
    @Test
    void shouldAcceptACarIsLessThan80PercentFull() {
        ParkingLot parkingLot = new ParkingLot(1, new Owner());
        Car car = new Car();

        assertThat(parkingLot.accept(car), is(true));
    }

    @Test
    void shouldNotAcceptACarIfTheLotIsMoreThan80PercentFull() {
        ParkingLot parkingLot = new ParkingLot(5, new Owner());

        assertTrue(parkingLot.accept(new Car()));
        assertTrue(parkingLot.accept(new Car()));
        assertTrue(parkingLot.accept(new Car()));
        assertTrue(parkingLot.accept(new Car()));
        assertFalse(parkingLot.accept(new Car()));
    }

    @Test
    void shouldRemoveACar() {
        ParkingLot parkingLot = new ParkingLot(1, new Owner());
        Car car = new Car();
        parkingLot.accept(car);

        assertThat(parkingLot.remove(car), is(true));
    }

    @Test
    void shouldNotNotifyParkingLotOwnerWhenUsageIsBelow75Percent() {
        Owner owner = mock(Owner.class);
        ParkingLot parkingLot = new ParkingLot(2, owner);
        parkingLot.accept(new Car());

        verify(owner, never()).usageOver75Percent(parkingLot);
    }

    @Test
    void shouldNotifyParkingLotOwnerWhenUsageIsOver75Percent() {
        Owner owner = mock(Owner.class);
        ParkingLot parkingLot = new ParkingLot(5, owner);

        parkingLot.accept(new Car());
        parkingLot.accept(new Car());
        parkingLot.accept(new Car());
        parkingLot.accept(new Car());

        verify(owner).usageOver75Percent(parkingLot);
    }
}
