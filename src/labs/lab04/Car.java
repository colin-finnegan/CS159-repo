package labs.lab04;

/**
 * Lab 4: Writing A Class.
 *
 * @author Colin Finnegan
 * @version 02/15/2024
 */
public class Car {
    private String make;
    private double speed;
    private int year;

    /**
     * Constructs a Car object.
     *
     * @param make the Car's make
     * @param year the Car's year
     */
    public Car(String make, int year) {
        this.make = make;
        this.year = year;
        this.speed = 0;
    }

    public String getMake() {
        return make;
    }

    public double getSpeed() {
        return speed;
    }

    public int getYear() {
        return year;
    }

    /**
     * Accelerates the ar by 5 mph.
     *
     * @return String of past speed + 5 mph
     */
    public String accelerate() {
        if (speed < 150) {
            speed += 5;
            return String.format("%.1f + 5.0 = %.1f", speed - 5, speed);
        }
        return "150.0 + 0.0 = 150.0";
    }

    /**
     * Slows down the car by 5 mph.
     */
    public void brake() {
        if (speed > 0) {
            speed -= 5;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return car.make.equals(this.make) && car.year == this.year;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("A %d %s that is going %.1f mph",
            year, make, speed);
    }

}
