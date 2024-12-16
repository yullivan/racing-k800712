package racing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void testCarConstructor() {
        Car car = new Car("TestCar");
        assertEquals("TestCar", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    void testCarConstructorWithLongName() {
        assertThrows(IllegalArgumentException.class, () -> new Car("VeryLongCarName"));
    }

    @Test
    void testMove() {
        Car car = new Car("TestCar");
        car.move(6); // Assuming 6 is above the ForwardThreshold
        assertTrue(car.getPosition() > 0);
    }

    @Test
    void testToString() {
        Car car = new Car("TestCar");
        car.move(6); // Move the car
        assertTrue(car.toString().startsWith("TestCar 🚗"));
    }

    @Test
    void testCarMovement() {
        Car car = new Car("TestCar");
        int initialPosition = car.getPosition();


        car.move(6);
        assertTrue(car.getPosition() > initialPosition);


        int currentPosition = car.getPosition();
        car.move(5);
        assertEquals(currentPosition, car.getPosition());
    }

    @Test
    void testTotalDistanceAndMoveCount() {
        Car car = new Car("TestCar");
        int initialMoveCount = car.getMoveCount();
        int initialTotalDistance = car.getTotalDistance();

        car.move(6);
        assertTrue(car.getMoveCount() > initialMoveCount);
        assertTrue(car.getTotalDistance() > initialTotalDistance);
    }


    @Test
    void move() {
    }

    @Test
    void getName() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void testToString1() {
    }

    @Test
    void testToString2() {
    }

    @Test
    void testToString3() {
    }

    @Test
    void testToString4() {
    }
}

