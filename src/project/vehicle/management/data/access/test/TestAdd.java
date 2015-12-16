package project.vehicle.management.data.access.test;

import java.io.IOException;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestAdd {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("testadd");
        Car car1 = new Car("121", "121", Category.CERTIFIED, 2015, "Audi",
                "Audi", "None", "SUV", 2f);
        Car car2=new Car("98771", "31231", Category.NEW, 1986, "BMW",
                "X5", "None", "SUV", 3502f);
        Car car3=new Car("98123", "mcgee", Category.USED, 2020, "Toyota",
                "Highlander", "None", "SUV", 3502f);
        test.addCar(car1);
        test.addCar(car2);
        test.addCar(car3);
        //we can find the car information in file 'testadd', it's the same as the code beyond
    }

}
