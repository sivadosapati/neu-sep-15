package project.vehicle.management.data.access.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestBuildCarList {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("gmps-gilroy");
        List<Car> list = test.listCars();
        Car actual = list.get(0);
        Assert.assertEquals(list.size(), 206);
        Assert.assertEquals("2646859273", actual.getID());
    }

}
