package velykyi.vladyslav.chapter2;

/**
 * Cannot be inherited
 */
@SuppressWarnings("unused")
public class Item1 {

    double x, y;

    @Override
    public String toString() {
        return "Item1{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    enum Angle {RAD, DEG}

    public Item1(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param dummy not being used
     */
    private Item1(double rho, double phi, int dummy) {
        this.x = rho * Math.cos(phi);
        this.y = phi * Math.sin(phi);
    }

    /**
     * @param unit - one constructor, based on enum - impl
     */
    private Item1(double rho, double phi, Angle unit) {
        switch (unit) {
            case RAD -> {
                this.x = rho * Math.cos(phi);
                this.y = rho * Math.sin(phi);
            }
            case DEG -> {
                double phi1 = phi * Math.PI/180.0;
                this.x = rho * Math.cos(phi1);
                this.y = rho * Math.sin(phi1);
            }
        }
    }

    /**
     * This is the best practice in Java.
     */
    public static Item1 fromCartesian(double x, double y) {
        return new Item1(x, y);
    }

    /**
     * This is the best practice in Java.
     */
    public static Item1 fromPolar(double x, double y, Angle unit) {
        return new Item1(x, y, unit);
    }
}
