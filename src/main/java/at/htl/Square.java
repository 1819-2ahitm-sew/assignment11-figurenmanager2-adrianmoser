package at.htl;

public class Square extends Figure {

    private float length;
    private Point upperLeftCorner;

    public Square(float length, Point upperLeftCorner) {
        this.length = length;
        this.upperLeftCorner = upperLeftCorner;
    }

    public double area() {

        return length * length;

    }

    public double circumference() {

        return 4 * length;

    }

    public float getLength() {
        return length;
    }

    public Point getUpperLeftCorner() {
        return upperLeftCorner;
    }

    public String toString() {

        return String.format("Quadrat mit Seitenlänge %.2f: Fläche -> %.2f, Umfang -> %.2f", length, area(), circumference());

    }
}
