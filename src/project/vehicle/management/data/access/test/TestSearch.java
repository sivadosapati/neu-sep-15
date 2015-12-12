package project.vehicle.management.data.access.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestSearch {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("gmps-gilroy");
        //define SearchFilter
        boolean[] category = {false, false, false};
        SearchFilter sf = new SearchFilter(category, null, null, null, null, null,"254962");
        List<Car> list = test.search(sf);
        int size = list.size();
        Assert.assertEquals(1, size);
        String id = list.get(0).getID();
        Assert.assertEquals("2549627053", id);
    }

}