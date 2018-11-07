package rectangle;

import org.junit.jupiter.api.Test;
import rectangle.Rectangle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    @Test
    void ensuresTheRectangleExists() {
        Rectangle rectangle = new Rectangle(1, 1);

        assertThat(rectangle, is(notNullValue()));
    }

    @Test
    void ensuresWidthIsNotZero() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(0, 1));
    }

    @Test
    void ensuresHeightIsNotZero() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(1, 0));
    }

    @Test
    void ensuresWidthIsNotNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1, 1));
    }

    @Test
    void ensuresHeightIsNotNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(1, -1));
    }

    @Test
    void ensuresReturnItsPerimeter() {
        Rectangle rectangle = new Rectangle(2, 1);

        assertThat(rectangle.getPerimeter(), is(6L));
    }

    @Test
    void ensuresPerimeterDoesNotOverflow() {
        Rectangle rectangle = new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE);

        assertThat(rectangle.getPerimeter(), is(8589934588L));
    }

    @Test
    void ensuresReturnItsArea() {
        Rectangle rectangle = new Rectangle(2, 3);

        assertThat(rectangle.getArea(), is(6L));
    }

    @Test
    void ensuresAreaDoesNotOverflow() {
        Rectangle rectangle = new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE);

        assertThat(rectangle.getArea(), is(4611686014132420609L));
    }
}
