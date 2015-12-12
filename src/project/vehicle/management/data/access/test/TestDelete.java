package project.vehicle.management.data.access.test;

import java.io.IOException;
import org.junit.Test;

import project.vehicle.management.data.access.CarManagerImpl;

public class TestDelete {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("testdelete&update");
        test.deleteCar("1212");
    }

}