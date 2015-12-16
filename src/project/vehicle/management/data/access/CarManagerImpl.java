package project.vehicle.management.data.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import project.vehicle.management.data.Car;
import project.vehicle.management.data.Category;
import project.vehicle.management.data.Range;
import project.vehicle.management.data.SearchFilter;
import project.vehicle.management.data.SortCriteria;

/**
 * @author: Zhang Yang, Liu Yang, Jia Jigang, Ma Changzheng
 * 
 */
public class CarManagerImpl implements CarManager {

    private String dealerID;
    private File file;
    private List<Car> carList;

    public CarManagerImpl(String dealerID) throws IOException {
        this.setDealerID(dealerID);
        this.file = new File(dealerID);
        this.carList = buildCarList();
    }

    /**
     * Get dealer ID of certain CarManagerImpl instance
     * 
     * @param none
     * @return the dealer id of certain CarManagerImpl instance
     */
    public String getDealerID() {
        return dealerID;
    }

    /**
     * Set the dealerID for an CarManagerImpl
     * 
     * @param dealerID an Dealer id of which is being applied to the CarManagerImpl
     * @return none
     */
    public void setDealerID(String dealerID) {
        this.dealerID = dealerID;
    }

    /**
     * Read the corresponding file of the dealer, convert data into a list of cars
     * 
     * @param none
     * @return all the cars of certain dealer.
     * @exception IOException On input error
     * @see IOException
     */
    private List<Car> buildCarList() throws IOException {
        final List<Car> cars = new ArrayList<Car>();
        FileReadingTemplate template = new FileReadingTemplate() {
            @Override
            public void processLine(String line) {
                cars.add(lineToCar(line));
            }
        };
        template.setSkipFirstLine(true);
        template.parseFile(file);
        return cars;
    }

    /**
     * Split each line in file with "~" to get car information and build a car.
     * 
     * @param line each line in file, except the first line
     * @return the corresponding car of the line in the file
     */
    private Car lineToCar(String line) {
        String[] l = line.split("~");
        String id = l[0];
        String dealerId = l[1];
        Category category = Category.valueOf(l[2].toUpperCase());
        Integer year = Integer.parseInt(l[3]);
        String make = l[4];
        String model = l[5];
        String trim = l[6];
        String type = l[7];
        Float price = Float.parseFloat(l[8]);
        return new Car(id, dealerId, category, year, make, model, trim, type, price);
    }

    /**
     * Get all the cars of this dealer
     * 
     * @param none
     * @return all the cars of certain dealer, without searching and sorting
     */
    @Override
    public List<Car> listCars() {
        return carList;
    }

    /**
     * Get cars which match defined SearchFilter
     * 
     * @param sf an defined SearchFilter which is being applied
     * @return all the cars meet the condition.
     */
    @Override
    public List<Car> search(SearchFilter sf) {
        List<Car> result = new ArrayList<Car>();
        for (int i = 0; i < carList.size(); i++) {
            if (checkSearchCondition(carList.get(i), sf))
                result.add(carList.get(i));
        }
        return result;
    }

    /**
     * Check if a car meets the condition of a SearchFilter
     * 
     * @param car a car which is being check
     * @param sf a defined search filter
     * @return true if the car meet condition, otherwise false
     */
    private boolean checkSearchCondition(Car car, SearchFilter sf) {
        if (!checkCondition(sf.getMake(), car.getMake()))
            return false;
        if (!checkCondition(sf.getModel(), car.getModel()))
            return false;
        if (!checkCondition(sf.getTrim(), car.getTrim()))
            return false;
        if (!checkCondition(sf.getYear(), car.getYear() + 0.0f))
            return false;
        if (!checkCondition(sf.getRange(), car.getPrice()))
            return false;
        if (!checkCondition(sf.getCategory(), car.getCategory()))
            return false;
        if (!checkCondition(car, sf.getKeywords()))
            return false;
        return true;
    }

    /**
     * Check if the information of a car contains one or more keywords
     * 
     * @param car a car which is being check
     * @param keywords the keyword string from UI
     * @return true if the car meet condition, otherwise false
     */
    private boolean checkCondition(Car car, String keywords) {
        if (keywords == null || keywords.equals(""))
            return true;
        String words[] = keywords.split(" ");
        String carInfo = car.toString();
        for (String str : words) {
            if (carInfo.indexOf(str) != -1)
                return true;
        }
        return false;
    }

    /**
     * Check if the boolean array meets the condition of the defined category of a car
     * 
     * @param cc an boolean array which is being check
     * @param category a defined category
     * @return true if the boolean array meet condition, otherwise false
     */
    private boolean checkCondition(boolean[] cc, Category category) {
        if ((!cc[0]) && (!cc[1]) && (!cc[2]))
            return true;
        if (cc[0])
            if (category.equals(Category.NEW))
                return true;
        if (cc[1])
            if (category.equals(Category.USED))
                return true;
        if (cc[2])
            if (category.equals(Category.CERTIFIED))
                return true;
        return false;
    }

    /**
     * Check if one string equals another
     * 
     * @param str1 a string
     * @param str2 another string
     * @return true if two strings the same, otherwise false
     */
    private boolean checkCondition(String str1, String str2) {
        if (str1 != null)
            if (!str1.equals(str2))
                return false;
        return true;
    }

    /**
     * Check if a price is in a certain price range
     * 
     * @param range a price range
     * @param price a float number
     * @return true if price is in a the range, otherwise false
     * @see Range
     */
    private boolean checkCondition(Range range, Float price) {
        if (range != null) {
            if (range.getMax() != null)
                if (range.getMax() < price)
                    return false;
            if (range.getMin() != null)
                if (range.getMin() > price)
                    return false;
        }
        return true;
    }

    /**
     * Add a car to the car list and write to file
     * 
     * @param car a car which is being added
     * @return none
     * @exception IOException On input error
     */
    @Override
    public void addCar(Car car) throws IOException {
        this.carList.add(car);
        addToFile(car.toString());
    }

    /**
     * Write a string in the file
     * 
     * @param str a string which is being written
     * @return none
     * @exception IOException On output error
     */
    public void addToFile(String str) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write(str);
        bw.close();
        fw.close();
    }

    /**
     * Delete a car with certain vehicleId in the car list and delete the car data in file
     * 
     * @param vehicleId a string whose car is being deleted
     * @return none
     * @exception IOException On output error
     */
    @Override
    public void deleteCar(String vehicleId) throws IOException {
        coverFile();
        for (int i = 0; i < carList.size();) {
            if (carList.get(i).getID().equals(vehicleId))
                carList.remove(i);
            else
                addToFile(carList.get(i++).toString());
        }
    }

    /**
     * Clear up file and ready to rewrite
     * 
     * @param none
     * @return none
     * @exception IOException On output error
     */
    private void coverFile() throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write("id~webId~category~year~make~model~trim~type~price");
        fw.close();
    }

    /**
     * Update the data of a car in the car list
     * 
     * @param car a car which is being modified
     * @return none
     * @exception IOException On output error
     */
    @Override
    public void updateCar(Car car) throws IOException {
        int count = 0;
        for (Car c : carList) {
            if (c.getID().equals(car.getID()))
                break;
            count++;
        }
        carList.add(count, car);
        carList.remove(count + 1);
        coverFile();
        for (Car c : carList)
            addToFile(c.toString());
    }

    /**
     * Sort the car list according to defined SearchFilter and SortCriteria
     * 
     * @param sf a defined SearchFilter
     * @param sc a defined SortCriteria
     * @return the list of filtered car in certain order
     */
    @Override
    public List<Car> sort(SearchFilter sf, SortCriteria sc) throws IOException {
        // search satisfied data
        // carList.clear();
        searchFilterCar(sf);
        sortFilterCar(sc);
        return carList;
    }

    // sort these car data inside search result
    public void sortFilterCar(SortCriteria sc) {
        CarComparator ascComparator = new CarComparator();
        ascComparator.setAttribute(sc.getAttribute());
        Collections.sort(carList, ascComparator);
        if (!sc.getSequence()) {
            Comparator<Car> descComparator = Collections.reverseOrder(ascComparator);
            Collections.sort(carList, descComparator);
        }
        // return carList;
    }

    // get the car data which need to sort
    public void searchFilterCar(SearchFilter sf) throws IOException {
        if (carList == null) {
            carList = buildCarList();
        }
        carList = search(sf);
    }

    /**
     * Get non-duplicated make list of car list
     * 
     * @param none
     * @return a list of String of non-duplicated makes
     */
    @Override
    public List<String> setMake() {
        HashSet<String> makes = new HashSet<String>();
        for (Car car : carList) {
            makes.add(car.getMake());
        }
        return new ArrayList<String>(makes);
    }

    /**
     * Get non-duplicated model list in car list
     * 
     * @param make the make of the car
     * @return a list of String of non-duplicated models
     */
    @Override
    public List<String> setModel(String make) {
        HashSet<String> models = new HashSet<String>();
        for (Car car : carList) {
            if (car.getMake().equals(make))
                models.add(car.getModel());
        }
        return new ArrayList<String>(models);
    }

    /**
     * Get non-duplicated trim list in car list
     * 
     * @param modle the model of the car
     * @param make the make of the car
     * @return a list of String of non-duplicated trims
     */
    @Override
    public List<String> setTrim(String model, String make) {
        HashSet<String> trims = new HashSet<String>();
        for (Car car : carList) {
            if (car.getMake().equals(make))
                if (car.getModel().equals(model))
                    trims.add(car.getTrim());
        }
        return new ArrayList<String>(trims);
    }
}
