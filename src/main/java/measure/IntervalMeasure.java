package measure;

import java.util.Objects;

public class IntervalMeasure {
    public static final double DELTA = 0.0001;
    final double value;
    final Unit unit;

    public IntervalMeasure(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervalMeasure that = (IntervalMeasure) o;
        return (Math.abs(that.unit.toBaseUnit(that.value) - this.unit.toBaseUnit(this.value)) < DELTA)
                && that.unit.isComparableWith(this.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }
}
