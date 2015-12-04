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
        return new Car(l[0], l[1], Category.valueOf(l[2].toUpperCase()), Integer.parseInt(l[3]), l[4],
                l[5], l[6], l[7], Float.parseFloat(l[8]));
    }
    
    public CarManagerImpl(String dealerID) throws IOException {
        this.dealerID = dealerID;
        String filePath = dealerID;
        this.file = new File(filePath);
        this.carList = buildCarList(dealerID);        
    }
    
    
    @Override
    public List<Car> listCars() {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#deleteCar(java.lang.String)
     */
    @Override
    public void deleteCar(String vehicleId) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#updateCar(project.vehicle.management.data.Car)
     */
    @Override
    public void updateCar(Car car) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see project.vehicle.management.data.access.CarManager#sort(project.vehicle.management.data.SearchFilter, project.vehicle.management.data.SortCriteria)
     */
    @Override
    public List<Car> sort(SearchFilter sf, SortCriteria sc) {
        // TODO Auto-generated method stub
        return null;
    }

}
