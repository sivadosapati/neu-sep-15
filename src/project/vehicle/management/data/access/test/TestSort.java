package project.vehicle.management.data.access.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.SortCriteria;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestSort {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("gmps-gilroy");
        SearchFilter sf = new SearchFilter(null, null, null, null, null, null, null);
        //test year ascending
        SortCriteria sc = new SortCriteria("Year", true);
        List<Car> list = test.sort(sf, sc);
        String id = list.get(0).getID();
        Assert.assertEquals("2549627053", id);
        
        //test year descending
        sc = new SortCriteria("Year", false);
        list = test.sort(sf, sc);
        int year = list.get(0).getYear();
        Assert.assertEquals(2016, year);
        
        //test price ascending
        sc = new SortCriteria("Price", true);
        list = test.sort(sf, sc);
        id = list.get(0).getID();
        Assert.assertEquals("2652941043", id);
        
        //test price descending
        sc = new SortCriteria("Price", false);
        list = test.sort(sf, sc);
        id = list.get(0).getID();
        Assert.assertEquals("2662054263", id);
    }

}
