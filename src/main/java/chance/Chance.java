package chance;// A chance.Chance class understands the probability of events happening

import java.util.Objects;

public class Chance {
    public static final double TOTAL_CHANCE = 1.0;
    public static final double DELTA = 0.00000000000001;
    private final double value;

    public Chance(double value) {
        this.value = value;
    }

    public static Chance of(double value) {
        return new Chance(value);
    }

    public Chance not() {
        return new Chance(TOTAL_CHANCE - this.value);
    }

    public Chance and(Chance that) {
        return new Chance(that.value * this.value);
    }

    public Chance or(Chance that) {
        // This implementation is following Morgan's law
        return (this.not().and(that.not())).not();
        // not(and(this.not(), that.not()))
    }

    @Override
    public boolean equals(Object that) {
        return Math.abs(((Chance) that).value - this.value) < DELTA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

