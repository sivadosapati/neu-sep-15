package project.vehicle.management.data.access.test;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.Range;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.access.CarManagerImpl;

public class TestSearch {

    @Test
    public void test() throws IOException {
        CarManagerImpl test = new CarManagerImpl("gmps-gilroy");
        //define SearchFilter, key word search
        boolean[] category = {false, false, false};
        SearchFilter sf1 = new SearchFilter(category, null, null, null, null, null,"254962");
        List<Car> list1 = test.search(sf1);
        int size = list1.size();
        Assert.assertEquals(1, size);
        String id = list1.get(0).getID();
        Assert.assertEquals("2549627053", id);
        
        SearchFilter sf2 = new SearchFilter(category, null, null, null, null, null,"Ford");
        List<Car> list2 = test.search(sf2);
        for(int i=0;i<list2.size();i++){
           	Assert.assertEquals("Ford", list2.get(i).getMake());
        }
        
        
        Range r= new Range(2013,2015);
        SearchFilter sf3 = new SearchFilter(category, null, null, null, r, null,null);
        List<Car> list3 = test.search(sf3);
        for(int i=0;i<list3.size();i++){
        	Assert.assertTrue(list3.get(i).getYear().intValue()<=2015);
        	Assert.assertTrue(list3.get(i).getYear().intValue()>=2013);
        }
        
        Range ra= new Range(5000,15000);
        SearchFilter sf4 = new SearchFilter(category, null, null, null, null, ra,null);
        List<Car> list4 = test.search(sf4);
        for(int i=0;i<list4.size();i++){
        	Assert.assertTrue(list4.get(i).getPrice()<=15000f);
        	Assert.assertTrue(list4.get(i).getPrice()>=5000f);
        }
        
        boolean[] category2 = {false, true, false};
        SearchFilter sf5 = new SearchFilter(category2, null, null, null, null, null,null);
        List<Car> list5 = test.search(sf5);
        for(int i=0;i<list5.size();i++){
        	Assert.assertEquals(list5.get(i).getCategory(),Category.USED);
        }
        
    }

}
