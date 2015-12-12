package project.vehicle.management.data.access.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestAdd {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("testadd");
        //define SearchFilter
        Car car = new Car("121", "121", Category.CERTIFIED, 2015, "Audi",
                "Audi", "None", "SUV", 2f);
        test.addCar(car);
        //String id = list.get(0).getID();
        //Assert.assertEquals("2549627053", id);
    }

}