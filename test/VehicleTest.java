package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Car;
import main.Motorcycle;
import main.Vehicle;

class VehicleTest {

    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("BMV", "X5", 2018);
        motorcycle = new Motorcycle(" Yamaha", " YZF-R25", 2014);
    }

    @AfterEach
    void tearDown() {
        car = null;
        motorcycle = null;
    }

    @Test
    @DisplayName("Проверка принадлежности машины к транспортным средствам")
    void CarIsInstanceOfVehicleTest() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    @DisplayName("Проверка что машина создается с 4 колесами")
    void CarHasFourWheelsTest() {
        assertEquals(car.getNumWheels(), 4);
    }

    @Test
    @DisplayName("Проверка что мотоцикл создается с 2 колесами")
    void MotorcycleHasTwoWheelsTest() {
        assertEquals(motorcycle.getNumWheels(), 2);
    }

    @Test
    @DisplayName("Проверка что машина развивает скорость 60 в режиме тестового вождения")
    void DriveCarTest() {
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    @Test
    @DisplayName("Проверка что мотоцикл развивает скорость 75 в режиме тестового вождения")
    void DriveMotorcycleTest() {
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(), 75);
    }

    @Test
    @DisplayName("Проверка что машина правильно паркуется")
    void CarParkingTest() {
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }

    @Test
    @DisplayName("Проверка что мотоцикл правильно паркуется")
    void MotorcycleParkingTest() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(), 0);
    }
}