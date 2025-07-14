import java.util.ArrayList;
import java.util.Scanner;

public class Search {

    public static void searchMenu(ArrayList<Car> cars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How would you like to search the list?");
        System.out.println("- brand\n- model\n- year\n- price\n- millage\n- fuel\n- sellerName\n- sellerCity");

        String input = sc.nextLine().trim().toLowerCase();
        Car result = null;

        switch (input) {
            case "brand":
                System.out.println("Enter brand:");
                String brand = sc.nextLine().trim().toLowerCase();
                for (Car car : cars) {
                    if (car.getBrand().toLowerCase().contains(brand)) {
                        result = car;
                        break;
                    }
                }
                break;

            case "model":
                System.out.println("Enter model:");
                String model = sc.nextLine().trim().toLowerCase();
                for (Car car : cars) {
                    if (car.getModel().toLowerCase().contains(model)) {
                        result = car;
                        break;
                    }
                }
                break;

            case "year":
                System.out.println("Enter year:");
                int year = Integer.parseInt(sc.nextLine().trim());
                for (Car car : cars) {
                    if (car.getYear() == year) {
                        result = car;
                        break;
                    }
                }
                break;

            case "price":
                System.out.println("Enter max price:");
                double price = Double.parseDouble(sc.nextLine().trim());
                for (Car car : cars) {
                    if (car.getPrice() <= price) {
                        result = car;
                        break;
                    }
                }
                break;

            case "millage":
                System.out.println("Enter max millage:");
                int millage = Integer.parseInt(sc.nextLine().trim());
                for (Car car : cars) {
                    if (car.getMillage() <= millage) {
                        result = car;
                        break;
                    }
                }
                break;

            case "fuel":
                System.out.println("Enter fuel type:");
                String fuel = sc.nextLine().trim().toUpperCase();
                for (Car car : cars) {
                    if (car.getFuel().name().equalsIgnoreCase(fuel)) {
                        result = car;
                        break;
                    }
                }
                break;

            case "sellername":
                System.out.println("Enter seller name:");
                String sellerName = sc.nextLine().trim().toLowerCase();
                for (Car car : cars) {
                    if (car.getSeller().getFullname().toLowerCase().contains(sellerName)) {
                        result = car;
                        break;
                    }
                }
                break;

            case "sellercity":
                System.out.println("Enter seller city:");
                String sellerCity = sc.nextLine().trim().toLowerCase();
                for (Car car : cars) {
                    if (car.getSeller().getCity().toLowerCase().contains(sellerCity)) {
                        result = car;
                        break;
                    }
                }
                break;

            default:
                System.out.println("Invalid search option.");
                return;
        }

        if (result == null) {
            System.out.println("No cars matched your search.");
        } else {
            System.out.println("\nFirst result:");
            System.out.println(result);

            System.out.println("Would you like to edit anything about this listing? yes/no");
            String ans = sc.nextLine().trim().toLowerCase();

            if (ans.equals("yes")) {
                Edit.edit(result);
            }
        }
    }
}
