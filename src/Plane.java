/**
 * Represents a plane with attributes such as name, year, weight, max speed, and range.
 */
public class Plane {
    private String name;
    private int year;
    private double weight;
    private double maxSpeed;
    private double range;

    /**
     * Constructs a new Plane object with the specified attributes.
     *
     * @param name      the name of the plane.
     * @param year      the year the plane was developed.
     * @param weight    the weight of the plane in kilograms.
     * @param maxSpeed  the maximum speed of the plane in km/h.
     * @param range     the maximum flight range of the plane in kilometers.
     */
    public Plane(String name, int year, double weight, double maxSpeed, double range) {
        this.name = name;
        this.year = year;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.range = range;
    }

    /**
     * @return the name of the plane.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the year the plane was developed.
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the weight of the plane in kilograms.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return the maximum speed of the plane in km/h.
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * @return the maximum flight range of the plane in kilometers.
     */
    public double getRange() {
        return range;
    }

    /**
     * Compares the current plane with another plane for equality based on all attributes.
     *
     * @param plane the plane to compare with the current plane.
     * @return true if all attributes match, false otherwise.
     */
    public boolean isEqual(Plane plane) {
        return this.name.equals(plane.getName()) && this.year == plane.getYear() && this.weight == plane.getWeight()
                && this.maxSpeed == plane.getMaxSpeed() && this.range == plane.getRange();
    }
}
