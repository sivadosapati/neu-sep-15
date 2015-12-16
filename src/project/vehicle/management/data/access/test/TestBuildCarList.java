package project.vehicle.management.data.access.test;

import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestBuildCarList {
    /**
     * BuidCarList() is a method in the constructor of class CarManagerImpl
     * so it would be executed after initiate a instance of CarManagerImpl
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("gmps-gilroy");
        List<Car> list = test.listCars();
        Assert.assertEquals(list.size(), 206);//the first line is not car information 
        
        Car actual = list.get(0);
        
        Assert.assertEquals("2646859273", actual.getID());
        Assert.assertEquals("Chevrolet", actual.getMake());
        Assert.assertTrue(2016==actual.getYear());
        Assert.assertEquals("gmps-gilroy", actual.getDealerID());
 //       Assert.assertEquals(Category.NEW, actual.getCategory());
        Assert.assertEquals("Colorado", actual.getModel());
        Assert.assertEquals("Extended Cab Long Box 2-Wheel Drive WT", actual.getTrim());
        Assert.assertEquals("TRUCK", actual.getType());
        Assert.assertTrue(26055.0f==actual.getPrice());
        
        Car lastCar = list.get(205);
       
        Assert.assertEquals("2644166533", lastCar.getID());
        Assert.assertEquals("Volkswagen", lastCar.getMake());
        Assert.assertTrue(2013==lastCar.getYear());
        Assert.assertEquals("gmps-gilroy",lastCar.getDealerID());
 //       Assert.assertEquals(Category.USED, lastCar.getCategory());
        Assert.assertEquals("Passat", lastCar.getModel());
        Assert.assertEquals("4dr Sdn 2.5L Auto SEL PZEV *Ltd Avail*", lastCar.getTrim());
        Assert.assertEquals("CAR", lastCar.getType());
        Assert.assertTrue(19671.0f==lastCar.getPrice());
    }

}
