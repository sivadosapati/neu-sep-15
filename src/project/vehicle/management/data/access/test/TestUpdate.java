package project.vehicle.management.data.access.test;

import java.io.IOException;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestUpdate {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("testadd");
        Car car = new Car("98771", "312312", Category.CERTIFIED, 2015, "BMW",
                "BMW", "None", "SUV", 200000f);
        test.updateCar(car);
    }

}
