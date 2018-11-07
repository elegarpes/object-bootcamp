package measure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntervalMeasureTest {
    @DisplayName("Should be equal when there is the same amount between")
    @Nested
    class ShouldBeEqual {

        @Test
        void feetAndMeters() {
            IntervalMeasure distance1 = new IntervalMeasure(5, Unit.FEET);
            IntervalMeasure distance2 = new IntervalMeasure(1.524, Unit.METERS);

            assertThat(distance1, is(distance2));
        }
        @Test
        void inchesAndYards() {
            IntervalMeasure distance1 = new IntervalMeasure(5, Unit.INCHES);
            IntervalMeasure distance2 = new IntervalMeasure(0.1389, Unit.YARDS);

            assertThat(distance1, is(distance2));
        }

        @Test
        void metersAndCentimeters() {
            IntervalMeasure distance1 = new IntervalMeasure(2, Unit.METERS);
            IntervalMeasure distance2 = new IntervalMeasure(200, Unit.CENTIMETERS);

            assertThat(distance1, is(distance2));
        }

        @Test
        void gallonsAndLiters() {
            IntervalMeasure measure1 = new IntervalMeasure(1, Unit.GALLONS);
            IntervalMeasure measure2 = new IntervalMeasure(3.7854, Unit.LITERS);

            assertThat(measure1, is(measure2));
        }

        @Test
        void fahrenheitAndCelsius() {
            IntervalMeasure measure1 = new IntervalMeasure(80, Unit.FAHRENHEIT);
            IntervalMeasure measure2 = new IntervalMeasure(26.6667, Unit.CELSIUS);

            assertThat(measure1, is(measure2));
        }
    }

    @DisplayName("Should not be equal when the volume is amount between")
    @Nested
    class ShouldNotBeEqual {

        @Test
        void feetAndMeter() {
            IntervalMeasure distance1 = new IntervalMeasure(5, Unit.FEET);
            IntervalMeasure distance2 = new IntervalMeasure(2, Unit.METERS);

            assertThat(distance1, not(distance2));
        }

        @Test
        void inchesAndYards() {
            IntervalMeasure distance1 = new IntervalMeasure(5, Unit.INCHES);
            IntervalMeasure distance2 = new IntervalMeasure(2, Unit.YARDS);

            assertThat(distance1, not(distance2));
        }

        @Test
        void metersAndCentimeters() {
            IntervalMeasure distance1 = new IntervalMeasure(2, Unit.METERS);
            IntervalMeasure distance2 = new IntervalMeasure(100, Unit.CENTIMETERS);

            assertThat(distance1, not(distance2));
        }

        @Test
        void gallonsAndLiters() {
            IntervalMeasure measure1 = new IntervalMeasure(5, Unit.GALLONS);
            IntervalMeasure measure2 = new IntervalMeasure(2, Unit.LITERS);

            assertThat(measure1, not(measure2));
        }
    }

    @Test
    void shouldAddTwoLengthMeasures() {
        RatioMeasure measure = new RatioMeasure(2, Unit.INCHES).plus(new RatioMeasure(1, Unit.METERS));

        assertThat(measure, is(new RatioMeasure(41.37008, Unit.INCHES)));
    }

    @Test
    void shouldAddTwoVolumeMeasures() {
        RatioMeasure measure = new RatioMeasure(3, Unit.LITERS).plus(new RatioMeasure(0.792516, Unit.GALLONS));

        assertThat(measure, is(new RatioMeasure(6, Unit.LITERS)));
    }
}
