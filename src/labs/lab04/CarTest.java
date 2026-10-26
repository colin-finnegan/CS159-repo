package labs.lab04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test the Car class.
 *
 * @author Colin Finnegan
 * @version 02/15/2024
 */
public class CarTest {

    @Test
    public void testConstructor() {
        Car one = new Car("Honda", 2009);
        assertEquals("Honda", one.getMake());
        assertEquals(2009, one.getYear());
        assertEquals(0, one.getSpeed());

        Car two = new Car("Acura", 2018);
        assertEquals("Acura", two.getMake());
        assertEquals(2018, two.getYear());
        assertEquals(0, two.getSpeed());
    }

    @Test
    public void testAcceleration() {
        Car car = new Car("Honda", 2009);
        String actual = car.accelerate();
        assertEquals("0.0 + 5.0 = 5.0", actual);
        assertEquals(5, car.getSpeed());

        car.brake();
        assertEquals(0, car.getSpeed());
    }

    @Test
    public void testSpeedLimits() {
        Car car = new Car("Jeep", 2004);
        car.brake();
        assertEquals(0, car.getSpeed());

        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        String actual = car.accelerate();
        assertEquals("145.0 + 5.0 = 150.0", actual);
        assertEquals(150, car.getSpeed());
        actual = car.accelerate();
        assertEquals("150.0 + 0.0 = 150.0", actual);
        assertEquals(150, car.getSpeed());

    }

    @Test
    public void testEquals() {
        Car car1 = new Car("Nissan", 2003);
        Car car2 = new Car("Nissan", 2003);
        Car car3 = new Car("Honda", 2003);
        Car car4 = new Car("Nissan", 2024);
        assertTrue(car1.equals(car2));
        assertFalse(car1.equals(car3));
        assertFalse(car1.equals(car4));
        assertFalse(car1.equals("car5"));
    }

    @Test
    public void testString() {
        Car car = new Car("Nissan", 2003);
        assertEquals("A 2003 Nissan that is going 0.0 mph", car.toString());
    }
}
