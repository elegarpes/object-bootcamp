package measure;

import java.util.function.Function;

public class Unit {
    public final static Unit METERS = new Unit();
    public final static Unit FEET = new Unit(multiplyByRate(0.3048), divideByRate(0.3048), Unit.METERS);
    public final static Unit INCHES = new Unit(multiplyByRate(0.0254), divideByRate(0.0254), Unit.METERS);
    public final static Unit YARDS = new Unit(multiplyByRate(0.9144), divideByRate(0.9144), Unit.METERS);
    public final static Unit CENTIMETERS = new Unit(multiplyByRate(0.01), divideByRate(0.01), Unit.METERS);
    public final static Unit LITERS = new Unit();
    public final static Unit GALLONS = new Unit(multiplyByRate(3.7854), divideByRate(3.7854), Unit.LITERS);
    public static final Unit CELSIUS = new Unit();
    public static final Unit FAHRENHEIT = new Unit(amount -> (amount - 32) * 5/9, amount -> amount *  9/5 + 32, Unit.CELSIUS);

    private final Function<Double, Double> toBase;
    private final Unit baseUnit;
    private final Function<Double, Double> fromBase;

    private static Function<Double, Double> multiplyByRate(double ratio) {
        return amount -> amount * ratio;
    }

    private static Function<Double, Double> divideByRate(double ratio) {//TODO use it
        return amount -> amount / ratio;
    }

    Unit(Function<Double, Double> toBase, Function<Double, Double> fromBase, Unit baseUnit) {
        this.toBase = toBase;
        this.fromBase = fromBase;
        this.baseUnit = baseUnit;
    }

    Unit() {
        this.baseUnit = this;
        this.toBase = amount -> amount;
        this.fromBase = toBase;
    }

    public double toBaseUnit(double amount) {
        return toBase.apply(amount);
    }

    public double toUnit(double amount, Unit unit) {
        return unit.fromBase.apply(toBaseUnit(amount));
    }

    public boolean isComparableWith(Unit unit) {
        return baseUnit.equals(unit.baseUnit);
    }

}
