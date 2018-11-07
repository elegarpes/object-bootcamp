package measure;

public class Unit {
    public final static Unit METERS = new Unit();
    public final static Unit FEET = new Unit(0.3048, Unit.METERS);
    public final static Unit INCHES = new Unit(0.0254, Unit.METERS);
    public final static Unit YARDS = new Unit(0.9144, Unit.METERS);
    public final static Unit CENTIMETERS = new Unit(0.01, Unit.METERS);
    public final static Unit LITERS = new Unit();
    public final static Unit GALLONS = new Unit(3.7854, Unit.LITERS);


    private final double baseRate;
    private final Unit baseUnit;

    Unit(double baseRate, Unit baseUnit) {
        this.baseRate = baseRate;
        this.baseUnit = baseUnit;
    }

    Unit() {
        this.baseRate = 1;
        this.baseUnit = this;
    }

    public double toBaseUnit(double amount) {
        return amount * baseRate;
    }

    public double toUnit(double amount, Unit unit) {
        return toBaseUnit(amount) / unit.baseRate;
    }

    public boolean isComparableWith(Unit unit) {
        return baseUnit.equals(unit.baseUnit);
    }

    public Measure addMeasures(double v1, double v2, Unit u2) {
        return new Measure(this.toBaseUnit(v1) + u2.toBaseUnit(v2), baseUnit);
    }
}
