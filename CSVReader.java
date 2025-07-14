import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        boolean isFirstLine = true;

        String file = "CarStoreListings_Team12\\cars.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                String id = parts[0];
                String brand = parts[1];
                String model = parts[2];
                int year = Integer.parseInt(parts[3]);
                double price = Double.parseDouble(parts[4]);
                int millage = Integer.parseInt(parts[5]);
                FuelType fuel = FuelType.valueOf(parts[6].toUpperCase());

                String Name = parts[7];
                String City = parts[8];
                String Number = parts[9];

                Seller seller = new Seller(Name, City, Number);
                Car c1 = new Car(id, brand, model, year, price, millage, fuel, seller);

            }
        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Parsing error: " + e.getMessage());
        }

    }

    public static void appendCarToCSV(Car car) {
        try (FileWriter writer = new FileWriter("CarStoreListings_Team12\\cars.csv", true)) {
            // Format: id,brand,model,year,price,millage,fuel,seller name,seller city,seller
            // phone
            writer.write(car.getId() + "," +
                    car.getBrand() + "," +
                    car.getModel() + "," +
                    car.getYear() + "," +
                    car.getPrice() + "," +
                    car.getMillage() + "," +
                    car.getFuel().name() + "," +
                    car.getSeller().getFullname() + "," +
                    car.getSeller().getCity() + "," +
                    car.getSeller().getNumber() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV: " + e.getMessage());
        }
    }
    public static void appendCarToCSV() {
        try (FileWriter writer = new FileWriter("CarStoreListings_Team12\\cars.csv", true)) {
            // Format: id,brand,model,year,price,millage,fuel,seller name,seller city,seller phone
            writer.write("id,brand,model,year,price,millage,fuel,seller name,seller city,seller phone\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV: " + e.getMessage());
        }
    }
    

    public static void clearCSV(String filePath) {
        try (FileWriter fw = new FileWriter(filePath, false)) {
            // Opening the file with append = false clears it
            fw.write(""); // Optionally, write headers here if you want to keep them
            System.out.println("CSV file cleared successfully.");
        } catch (IOException e) {
            System.out.println("Error clearing CSV: " + e.getMessage());
        }
    }
}
