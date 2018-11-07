package measure;

import java.util.Objects;

public class Measure {
    public static final double DELTA = 0.0001;
    private final double value;
    private final Unit unit;

    public Measure(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measure that = (Measure) o;
        return (Math.abs(that.unit.toBaseUnit(that.value) - this.unit.toBaseUnit(this.value)) < DELTA)
                && that.unit.isComparableWith(this.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public Measure plus(Measure other) {
        return new Measure(this.value + other.unit.toUnit(other.value, this.unit), this.unit);
    }

    @Override
    public String toString() {
        return "Measure{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
