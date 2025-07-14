import java.util.ArrayList;
import java.util.Scanner;

public class Filter {
    public static void filterMenu(ArrayList<Car> carList) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> filtered = new ArrayList<>(carList);  

        System.out.println("You can filter by any of the following. Leave blank to skip. Type 'stop' anytime to show results early.\n");

        System.out.print("Brand: ");
        String brand = sc.nextLine().trim();
        if (brand.equalsIgnoreCase("stop")) {
            showFiltered(filtered);
            return;
        }
        if (!brand.isEmpty()) {
            filtered.removeIf(car -> !car.getBrand().equalsIgnoreCase(brand));
        }

        System.out.print("Model: ");
        String model = sc.nextLine().trim();
        if (model.equalsIgnoreCase("stop")) {
            showFiltered(filtered);
            return;
        }
        if (!model.isEmpty()) {
            filtered.removeIf(car -> !car.getModel().equalsIgnoreCase(model));
        }

        System.out.print("Year: ");
        String yearInput = sc.nextLine().trim();
        if (yearInput.equalsIgnoreCase("stop")) {
            showFiltered(filtered);
            return;
        }
        if (!yearInput.isEmpty()) {
            try {
                int year = Integer.parseInt(yearInput);
                filtered.removeIf(car -> car.getYear() != year);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Skipping.");
            }
        }

        System.out.print("Price: ");
        String priceInput = sc.nextLine().trim();
        if (priceInput.equalsIgnoreCase("stop")) {
            showFiltered(filtered);
            return;
        }
        if (!priceInput.isEmpty()) {
            try {
                double price = Double.parseDouble(priceInput);
                filtered.removeIf(car -> car.getPrice() != price);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format. Skipping.");
            }
        }

        System.out.print("Millage: ");
        String millageInput = sc.nextLine().trim();
        if (millageInput.equalsIgnoreCase("stop")) {
            showFiltered(filtered);
            return;
        }
        if (!millageInput.isEmpty()) {
            try {
                int millage = Integer.parseInt(millageInput);
                filtered.removeIf(car -> car.getMillage() != millage);
            } catch (NumberFormatException e) {
                System.out.println("Invalid millage format. Skipping.");
            }
        }

        System.out.print("Fuel Type (e.g. DIESEL, PETROL, ELECTRIC): ");
        String fuelInput = sc.nextLine().trim();
        if (fuelInput.equalsIgnoreCase("stop")) {
            showFiltered(filtered);
            return;
        }
        if (!fuelInput.isEmpty()) {
            try {
                FuelType fuel = FuelType.valueOf(fuelInput.toUpperCase());
                filtered.removeIf(car -> car.getFuel() != fuel);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid fuel type. Skipping.");
            }
        }

        System.out.print("Seller Full Name: ");
        String sellerName = sc.nextLine().trim();
        if (sellerName.equalsIgnoreCase("stop")) {
            showFiltered(filtered);
            return;
        }
        if (!sellerName.isEmpty()) {
            filtered.removeIf(car -> !car.getSeller().getFullname().equalsIgnoreCase(sellerName));
        }

        System.out.print("Seller City: ");
        String sellerCity = sc.nextLine().trim();
        if (sellerCity.equalsIgnoreCase("stop")) {
            showFiltered(filtered);
            return;
        }
        if (!sellerCity.isEmpty()) {
            filtered.removeIf(car -> !car.getSeller().getCity().equalsIgnoreCase(sellerCity));
        }

        // Final display
        showFiltered(filtered);
    }

    private static void showFiltered(ArrayList<Car> filtered) {
        System.out.println("\nFiltered Results:");
        if (filtered.isEmpty()) {
            System.out.println("No cars matched your criteria.");
        } else {
            for (Car car : filtered) {
                System.out.println(car);
            }
        }
    }
}
