package chance;

import chance.Chance;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


class ChanceTest {
    @Test
    void shouldBeEqualWhenTheChancesAreTheSame() {
        assertThat(Chance.of(0.5), is(Chance.of(0.5)));
    }

    @Test
    void shouldBeDifferentWhenTheChancesAreNotTheSame() {
        assertThat(Chance.of(-1), not(Chance.of(1)));
        assertThat(Chance.of(1), not(Chance.of(-1)));
    }

    @Test
    void shouldReturnTheComplementaryChance() {
        assertThat(Chance.of((double) 1 / 6).not(), is(Chance.of((double) 5 / 6)));
        assertThat(Chance.of((double) 2 / 6).not(), is(Chance.of((double) 4 / 6)));
    }

    @Test
    void shouldReturnTheIntersectionOfTwoChances() {
        assertThat(Chance.of(0.1).and(Chance.of(0.2)), is(Chance.of(0.02)));
        assertThat(Chance.of(0.3).and(Chance.of(0.5)), is(Chance.of(0.15)));
    }

    @Test
    void shouldReturnTheUnionOfTwoChances() {
        assertThat(Chance.of(0.1).or(Chance.of(0.2)), is(Chance.of(0.28)));
        assertThat(Chance.of(0.3).or(Chance.of(0.4)), is(Chance.of(0.58)));

    }
}