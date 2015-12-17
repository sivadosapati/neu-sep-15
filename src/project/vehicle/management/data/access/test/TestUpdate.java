package project.vehicle.management.data.access.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestUpdate {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("testadd");
        List <Car>cars=test.listCars();
        Car temp=null;
        for(int i=0;i<cars.size();i++){
        	temp=cars.get(i);
        	if(temp.getDealerID().equals("98771")){
        		Assert.assertTrue(temp.getPrice()==3502f);
        		break;
        	}
        }
        
        Car car = new Car("98771", "312312", Category.CERTIFIED, 2015, "BMW",
                "BMW", "None", "SUV", 20000f);
        test.updateCar(car);
        System.out.println(temp.getPrice());
        for(int i=0;i<cars.size();i++){
        	temp=cars.get(i);
        	if(temp.getDealerID().equals("98771")){
        		Assert.assertTrue(temp.getPrice()==20000f);
        		break;
        	}
        }
        
        car.setPrice(3502f);
        test.updateCar(car);
        
    }

}
