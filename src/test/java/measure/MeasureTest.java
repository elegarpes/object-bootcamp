package measure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class MeasureTest {
    @DisplayName("Should be equal when there is the same amount between")
    @Nested
    class ShouldBeEqual {

        @Test
        void feetAndMeters() {
            Measure distance1 = new Measure(5, Unit.FEET);
            Measure distance2 = new Measure(1.524, Unit.METERS);

            assertThat(distance1, is(distance2));
        }
        @Test
        void inchesAndYards() {
            Measure distance1 = new Measure(5, Unit.INCHES);
            Measure distance2 = new Measure(0.1389, Unit.YARDS);

            assertThat(distance1, is(distance2));
        }

        @Test
        void metersAndCentimeters() {
            Measure distance1 = new Measure(2, Unit.METERS);
            Measure distance2 = new Measure(200, Unit.CENTIMETERS);

            assertThat(distance1, is(distance2));
        }

        @Test
        void gallonsAndLiters() {
            Measure measure1 = new Measure(1, Unit.GALLONS);
            Measure measure2 = new Measure(3.7854, Unit.LITERS);

            assertThat(measure1, is(measure2));
        }

        @Test
        void fahrenheitAndCelsius() {
            Measure measure1 = new Measure(80, Unit.FAHRENHEIT);
            Measure measure2 = new Measure(26.6667, Unit.CELSIUS);

            assertThat(measure1, is(measure2));
        }
    }

    @DisplayName("Should not be equal when the volume is amount between")
    @Nested
    class ShouldNotBeEqual {

        @Test
        void feetAndMeter() {
            Measure distance1 = new Measure(5, Unit.FEET);
            Measure distance2 = new Measure(2, Unit.METERS);

            assertThat(distance1, not(distance2));
        }

        @Test
        void inchesAndYards() {
            Measure distance1 = new Measure(5, Unit.INCHES);
            Measure distance2 = new Measure(2, Unit.YARDS);

            assertThat(distance1, not(distance2));
        }

        @Test
        void metersAndCentimeters() {
            Measure distance1 = new Measure(2, Unit.METERS);
            Measure distance2 = new Measure(100, Unit.CENTIMETERS);

            assertThat(distance1, not(distance2));
        }

        @Test
        void gallonsAndLiters() {
            Measure measure1 = new Measure(5, Unit.GALLONS);
            Measure measure2 = new Measure(2, Unit.LITERS);

            assertThat(measure1, not(measure2));
        }
    }

    @Test
    void shouldAddTwoLengthMeasures() {
        Measure measure = new Measure(2, Unit.INCHES).plus(new Measure(1, Unit.METERS));

        assertThat(measure, is(new Measure(41.37008, Unit.INCHES)));
    }

    @Test
    void shouldAddTwoVolumeMeasures() {
        Measure measure = new Measure(3, Unit.LITERS).plus(new Measure(0.792516, Unit.GALLONS));

        assertThat(measure, is(new Measure(6, Unit.LITERS)));
    }
}
