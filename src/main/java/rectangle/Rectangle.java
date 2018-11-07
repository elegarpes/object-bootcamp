package rectangle;// A rectangle understands a shape with four sides and all right angles

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        validateSides(width, height);

        this.width = width;
        this.height = height;
    }

    private void validateSides(int width, int height) {
        if (isNonPositive(width)) throw new IllegalArgumentException();
        if (isNonPositive(height)) throw new IllegalArgumentException();
    }

    private boolean isNonPositive(int side) {
        return side <= 0;
    }

    public long getPerimeter() {
        return 2L * width + 2L * height;
    }

    public long getArea() {
        return (long) width * height;
    }
}
