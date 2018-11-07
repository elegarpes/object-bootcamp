package measure;

public class RatioMeasure extends IntervalMeasure {

    public RatioMeasure(double value, Unit unit) {
        super(value, unit);
    }

    public RatioMeasure plus(RatioMeasure other) {
        return new RatioMeasure(this.value + other.unit.toUnit(other.value, this.unit), this.unit);
    }
}
