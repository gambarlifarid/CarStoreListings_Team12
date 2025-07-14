import java.util.Scanner;

public class Create {
    public static void create() {
        System.out.println("What is your name?");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        System.out.println("Surname?");
        String surname = sc.nextLine();
        String fullname = name + " " + surname;

        System.out.println("Which city are you from?");
        String city = sc.nextLine();
        System.out.println("Enter your phone number");
        String number = sc.nextLine();
        Seller s = new Seller(fullname, city, number);

        System.out.println("As for your car, what kind of Car are you looking to sell?");
        System.out.println("Enter brand name");
        String brand = sc.nextLine();
        System.out.println("Enter model:");
        String model = sc.nextLine();

        System.out.println("Enter year of manufacture:");
        int year = Integer.parseInt(sc.nextLine());

        System.out.println("Enter price:");
        double price = Double.parseDouble(sc.nextLine());

        System.out.println("Enter mileage (in km):");
        int millage = Integer.parseInt(sc.nextLine());

        System.out.println("Choose fuel type:");
        for (FuelType f : FuelType.values()) {
            System.out.println("- " + f.name());
        }
        FuelType fuel = null;
        while (fuel == null) {
            try {
                fuel = FuelType.valueOf(sc.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid fuel type. Try again:");
            }
        }

        String id = String.valueOf(Car.getCarList().size() + 1);

        Car newCar = new Car(id, brand, model, year, price, millage, fuel, s);

        System.out.println("Car registered successfully!");
        System.out.println(newCar);
        CSVReader.appendCarToCSV(newCar);
    }
}
