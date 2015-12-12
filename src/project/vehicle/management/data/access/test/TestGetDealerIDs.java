package project.vehicle.management.data.access.test;

import org.junit.Assert;
import org.junit.Test;

import project.vehicle.management.data.access.DealerCarManagerImpl;

public class TestGetDealerIDs {

    @Test
    public void test() {
        DealerCarManagerImpl dcm = new DealerCarManagerImpl();
        String[] ids = dcm.getDealerIds();
        Assert.assertEquals("gmps-priority",ids[0]);
        Assert.assertEquals("gmps-davis-chevrolet",ids[1]);
        Assert.assertEquals("gmps-gray-stroudsburg",ids[12]);
        Assert.assertEquals("gmps-mcgee",ids[6]);
        Assert.assertEquals("gmps-blue-ribbon",ids[16]);
        Assert.assertEquals("gmps-goldstein",ids[21]);
        Assert.assertEquals("gmps-mckenna",ids[22]);
        Assert.assertEquals("gmps-curry",ids[25]);
     
    }

}
