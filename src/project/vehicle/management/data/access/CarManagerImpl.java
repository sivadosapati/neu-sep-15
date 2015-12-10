/**
 * 
 */
package project.vehicle.management.data.access;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.SortCriteria;

/**
 * @author
 *
 */
public class CarManagerImpl implements CarManager {

	private List<Car> carList;
	private String dealerID;
	private File file;

	/*
	 * (non-Javadoc)
	 * 
	 * @see project.vehicle.management.data.access.CarManager#listCars()
	 */

	private List<Car> buildCarList() throws IOException {
		List<Car> result = new ArrayList<Car>();
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String thisLine = null;
		br.readLine(); // exclude the first line
		while ((thisLine = br.readLine()) != null) {
			result.add(lineToCar(thisLine));
		}
		br.close();
		return result;
	}

	private List<Car> buildCarListOld() throws IOException {
		final List<Car> cars = new ArrayList<Car>();
		FileReadingTemplate template = new FileReadingTemplate() {

			@Override
			public void processLine(String line) {
				cars.add(lineToCar(line));
			}
		};
		template.parseFile(file);
		return cars;
	}

	private Car lineToCar(String s) {
		String[] l = s.split("~");
		String id = l[0];
		String dealerId = l[1];
		Category category = Category.valueOf(l[2].toUpperCase());
		Integer year = Integer.parseInt(l[3]);
		String make = l[4];
		String model = l[5];
		String trim = l[6];
		String type = l[7];
		Float price = Float.parseFloat(l[8]);
		return new Car(id, dealerId, category, year, make, model, trim, type,
				price);
	}

	public CarManagerImpl(String dealerID) throws IOException {
		this.dealerID = dealerID;
		String filePath = dealerID;
		this.file = new File(filePath);
		this.carList = buildCarList();
	}

	@Override
	public List<Car> listCars() {
		return carList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * project.vehicle.management.data.access.CarManager#search(project.vehicle
	 * .management.data.SearchFilter)
	 */
	@Override
	public List<Car> search(SearchFilter sf) {
		List<Car> result = new ArrayList<Car>(carList);
		for (Car car : result) {
			if (!checkSearchCondition(car, sf))
				result.remove(car);
		}
		return result;
	}

	private boolean checkSearchCondition(Car car, SearchFilter sf) {
		if (sf.getMake() != null && !sf.getMake().equals(car.getMake()))
			return false;
		if (sf.getModel() != null && !sf.getModel().equals(car.getModel()))
			return false;
		if (sf.getTrim() != null && !sf.getTrim().equals(car.getTrim()))
			return false;
		if (sf.getYear() != null && sf.getYear() != car.getYear())
			return false;
		if (sf.getRange() != null) {
			if (sf.getRange().getMax() != null
					&& sf.getRange().getMax() < car.getPrice())
				return false;
			if (sf.getRange().getMin() != null
					&& sf.getRange().getMin() > car.getPrice())
				return false;
		}
		for (Category cc : sf.getCategory()) {
			if (car.getCategory().equals(cc))
				return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * project.vehicle.management.data.access.CarManager#addCar(project.vehicle
	 * .management.data.Car)
	 */
	@Override
	public void addCar(Car car) throws IOException {
		this.carList.add(car);
		StringBuffer tempCar = new StringBuffer();
		tempCar.append(car.getId() + "~").append(car.getDealerID() + "~")
				.append(car.getCategory().toString() + "~")
				.append(car.getYear() + "~");
		tempCar.append(car.getMake() + "~").append(car.getModel() + "~")
				.append(car.getTrim() + "~").append(car.getType() + "~")
				.append(car.getPrice());
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.write(tempCar.toString());
		bw.close();
		fw.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * project.vehicle.management.data.access.CarManager#deleteCar(java.lang
	 * .String)
	 */
	@Override
	public void deleteCar(String vehicleId) throws IOException {
		FileWriter fw = new FileWriter(file);
		fw.write(dealerID);
		fw.close();
		for (Car car : carList) {
			if (car.getId().equals(vehicleId)) {
				carList.remove(car);
				break;
			} else
				addCar(car);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * project.vehicle.management.data.access.CarManager#updateCar(project.vehicle
	 * .management.data.Car)
	 */
	@Override
	public void updateCar(Car car) {
		// update the carList and write to file;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * project.vehicle.management.data.access.CarManager#sort(project.vehicle
	 * .management.data.SearchFilter,
	 * project.vehicle.management.data.SortCriteria)
	 */
	@Override
	public List<Car> sort(SearchFilter sf, SortCriteria sc) {
		// override comparator.....
		return null;
	}

}
