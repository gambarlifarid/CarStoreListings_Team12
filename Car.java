import java.lang.reflect.Array;
import java.util.ArrayList;

public class Car {

    private static ArrayList<Car> carList = new ArrayList<>();
    private String id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private int millage;
    private FuelType fuel;
    private Seller seller;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    public FuelType getFuel() {
        return fuel;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Car(String id, String brand, String model, int year, double price, int millage, FuelType fuel,
            Seller seller) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.millage = millage;
        this.fuel = fuel;
        this.seller = seller;

        carList.add(this);
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nBrand: " + brand +
                "\nModel: " + model +
                "\nYear: " + year +
                "\nPrice: $" + price +
                "\nMileage: " + millage + " km" +
                "\nFuel Type: " + fuel +
                "\nSeller: " + seller + "\n";
    }

    public static ArrayList<Car> getCarList() {
        return carList;
    }
    public static String getNextAvailableId() {
        int maxId = 0;
        for (Car car : carList) {
            try {
                int currentId = Integer.parseInt(car.getId());
                if (currentId > maxId) {
                    maxId = currentId;
                }
            } catch (NumberFormatException e) {
                // skip non-numeric IDs, if any
            }
        }
        return String.valueOf(maxId + 1);
    }

}