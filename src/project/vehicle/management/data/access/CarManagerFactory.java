package project.vehicle.management.data.access;

import java.io.IOException;

public class CarManagerFactory {
    /**
     * Get CarManager of corresponding dealerID
     * 
     * @param   dealerId  a dealer ID of the certain CarManagerImpl instance
     * @return            corresponding CarManagerImpl
     */
	public CarManager getCarManager(String dealerId) throws IOException {
	    CarManagerImpl cmi = new CarManagerImpl(dealerId);
		return cmi;
	}
}
