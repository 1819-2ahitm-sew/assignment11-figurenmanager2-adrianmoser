package at.htl;

public class Circle extends Figure{

    private Point center;
    private float radius;

    public Circle(Point center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public double circumference() {
        return 2 * radius * Math.PI;
    }

    public Point getCenter() {
        return center;
    }

    public float getRadius() {
        return radius;
    }

    public String toString() {
        return String.format("Kreis mit Radius %.2f: Fläche -> %.2f, Umfang -> %.2f", radius, area(), circumference());
    }
}
