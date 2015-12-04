package project.vehicle.management.data.access;

import java.util.List;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.SortCriteria;

public interface CarManager {
	List<Car> listCars();

	List<Car> search(SearchFilter searchFilter);

	void addCar(Car car);

	void deleteCar(String vehicleId);

	void updateCar(Car car);

	List<Car> sort(SearchFilter sf, SortCriteria sc);
}
