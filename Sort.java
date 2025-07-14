import java.util.*;

public class Sort {
    public static void sortMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How would you like to sort the list?");
        System.out.println("- brand\n- model\n- year\n- price\n- millage\n- fuel\n- sellerName\n- sellerCity");

        String input = sc.nextLine().trim().toLowerCase();

        switch (input) {
            case "brand":
                Collections.sort(Car.getCarList(), Comparator.comparing(Car::getBrand));
                break;
            case "model":
                Collections.sort(Car.getCarList(), Comparator.comparing(Car::getModel));
                break;
            case "year":
                Collections.sort(Car.getCarList(), Comparator.comparingInt(Car::getYear));
                break;
            case "price":
                Collections.sort(Car.getCarList(), Comparator.comparingDouble(Car::getPrice));
                break;
            case "millage":
                Collections.sort(Car.getCarList(), Comparator.comparingInt(Car::getMillage));
                break;
            case "fuel":
                Collections.sort(Car.getCarList(), Comparator.comparing(Car::getFuel));
                break;
            case "sellername":
                Collections.sort(Car.getCarList(), Comparator.comparing(c -> c.getSeller().getFullname()));
                break;
            case "sellercity":
                Collections.sort(Car.getCarList(), Comparator.comparing(c -> c.getSeller().getCity()));
                break;
            default:
                System.out.println("Invalid sort option.");
        }
    }
}
