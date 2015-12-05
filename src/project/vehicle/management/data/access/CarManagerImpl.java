/**
 * 
 */
package project.vehicle.management.data.access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#listCars()
     */
    
    
    private List<Car> buildCarList(String dealerID) throws IOException {
        List<Car> result = new ArrayList<Car>();
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String  thisLine = null;
        br.readLine();               // exclude the first line
        while ((thisLine = br.readLine()) != null) {
            result.add(lineToCar(thisLine));
        } 
        br.close();
        return result;
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
        return new Car(id, dealerId, category, year, make,
                model, trim, type, price);
    }
    
    public CarManagerImpl(String dealerID) throws IOException {
        this.dealerID = dealerID;
        String filePath = dealerID;
        this.file = new File(filePath);
        this.carList = buildCarList(dealerID);        
    }
    
    
    @Override
    public List<Car> listCars() {
        return carList;
    }

    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#search(project.vehicle.management.data.SearchFilter)
     */
    @Override
    public List<Car> search(SearchFilter searchFilter) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#addCar(project.vehicle.management.data.Car)
     */
    @Override
    public void addCar(Car car) {
        // add to the carList and write to file;

    }

    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#deleteCar(java.lang.String)
     */
    @Override
    public void deleteCar(String vehicleId) {
        // delete the car in carList and delete in file;

    }

    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#updateCar(project.vehicle.management.data.Car)
     */
    @Override
    public void updateCar(Car car) {
        //update the carList and write to file;

    }

    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#sort(project.vehicle.management.data.SearchFilter, project.vehicle.management.data.SortCriteria)
     */
    @Override
    public List<Car> sort(SearchFilter sf, SortCriteria sc) {
        // override comparator.....
        return null;
    }

}
