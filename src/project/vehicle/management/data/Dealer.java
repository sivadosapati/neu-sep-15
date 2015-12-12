package project.vehicle.management.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import project.vehicle.management.data.access.CarManager;
import project.vehicle.management.data.access.CarManagerFactory;
import project.vehicle.management.data.access.DealerCarManagerImpl;

public class Dealer {
	private String id;
	private String name;
	private List<Car> cars = null;

	/**
	 * The constructor for Dealer
	 * 
	 * @param id the DealerID 
	 * */
	public Dealer(String id) throws IOException{
		this.id = id;
		this.setCars(new CarManagerFactory().getCarManager(id).listCars());
		this.name = "";
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
