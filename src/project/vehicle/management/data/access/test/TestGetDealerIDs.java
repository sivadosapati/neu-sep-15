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
    }

}
