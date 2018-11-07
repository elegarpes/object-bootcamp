package parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ParkingLotTest {
    @Test
    void shouldAcceptACar() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        assertThat(parkingLot.accept(car), is(true));
    }

    @Test
    void shouldNotAcceptACarIfTheLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();

        assertThat(parkingLot.accept(car1), is(true));
        assertThat(parkingLot.accept(car2), is(false));

    }

    @Test
    void shouldRemoveACar() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.accept(car);

        assertThat(parkingLot.remove(car), is(true));
    }

    @Test
    void shouldNotifyAttendantsWhenCapacityChanges() {
        ParkingLot parkingLot = new ParkingLot(3);
        Attendant parkingLotObserver = mock(Attendant.class);

        parkingLot.subscribe(parkingLotObserver);
        parkingLot.accept(new Car());

        verify(parkingLotObserver).capacityChanged(parkingLot,1, 3);
    }
}
