package ru.job4j.oop;
import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    @SuppressWarnings({"checkstyle:SimplifyBooleanReturn", "checkstyle:EmptyBlock"})
    public boolean exist(double ab, double ac, double bc) {
        boolean rsl = true;
        if (ab + bc > ac && ab + ac > bc && bc + ac > ab && ab != 0
                && ac != 0 && bc != 0) {
            return rsl;
        } else {
            rsl = false;
        }
        return rsl;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            /* написать формулу для расчета площади треугольника. */
            rsl = sqrt(p * (p - ac) * (p - ab) * (p - bc));
        }
        return rsl;
    }
}

