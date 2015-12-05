package project.vehicle.management.data.access;

import java.io.IOException;

public class CarManagerFactory {
	public CarManager getCarManager(String dealerId) throws IOException {
	    CarManagerImpl cmi = new CarManagerImpl(dealerId);
		return cmi;
	}
}
