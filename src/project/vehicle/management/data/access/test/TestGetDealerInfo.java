package project.vehicle.management.data.access.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;

public class TestGetDealerInfo {

    @Test
    public void test() throws IOException {
        Car car1 = new Car("121", "gmps-peach", Category.CERTIFIED, 2015, "Audi",
                "Audi", "None", "SUV", 2f);
        String result1[] = car1.getDealerInfo();
        String [] res1={"gmps-peach","en_US","www.peachchevrolet.com"};
        Assert.assertArrayEquals(result1, res1);
        
        Car car2=new Car("98123", "mcgee", Category.USED, 2020, "Toyota",
                "Highlander", "None", "SUV", 3502f);
        String result2 []=car2.getDealerInfo();
        String [] res2={"gmps-mcgee","en_US","www.mcgeechevyma.com"};
        Assert.assertArrayEquals(result2, res2);
        
        Car car3=new Car("98771", "31231", Category.NEW, 1986, "BMW",
                "X5", "None", "SUV", 3502f);
        String result3 []=car3.getDealerInfo();
        String [] res3=null;
        Assert.assertArrayEquals(result3, res3);//can not find the dealer info of '31231'
        
        Car car4=new Car("3342234", "lr", Category.USED, 1955, "Honda",
                "Accord", "None", "Sedan", 34234f);
        String result4[] =car4.getDealerInfo();
        String [] res4={"gmps-gilroy","en_US","www.gilroychevy.com"};
        Assert.assertArrayEquals(result4, res4);//'lr' is match with 'gmps-gilroy' 
    }

}
