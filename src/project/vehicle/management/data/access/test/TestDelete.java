package project.vehicle.management.data.access.test;

import java.io.IOException;
import org.junit.Test;

import project.vehicle.management.data.access.CarManagerImpl;

public class TestDelete {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("testadd");
        test.deleteCar("121");//if there is a car with ID '121', it will be deleted. Please check the file 'testadd'
        test.deleteCar("12123");//there is not a car with ID '12123', the file does not change after deleteCar execute
        test.deleteCar("98123");//if there is no car in file 'testadd',please execute the test case 'TestAdd' and check the file'testadd'
    }

}
