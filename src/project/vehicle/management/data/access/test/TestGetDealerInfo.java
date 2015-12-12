package project.vehicle.management.data.access.test;

import java.io.IOException;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;

public class TestGetDealerInfo {

    @Test
    public void test() throws IOException {
        Car car = new Car("121", "gmps-peach", Category.CERTIFIED, 2015, "Audi",
                "Audi", "None", "SUV", 2f);
        String result[] = car.getDealerInfo();
        System.out.println(result[0]+" "+result[1]+" "+result[2]);
    }

}