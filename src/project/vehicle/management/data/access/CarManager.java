package project.vehicle.management.data.access;

import java.io.IOException;
import java.util.List;

import project.vehicle.management.data.*;

public interface CarManager {
	List<Car> listCars();

	List<Car> search(SearchFilter searchFilter);

	void addCar(Car car) throws IOException;

	void deleteCar(String vehicleId) throws IOException;

	void updateCar(Car car) throws IOException;

	List<Car> sort(SearchFilter sf, SortCriteria sc);
}
