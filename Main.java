import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Load cars from CSV
        CSVReader csv = new CSVReader();
        csv.main(null);
        ArrayList<Car> workingList = new ArrayList<>(Car.getCarList()); // shallow copy for now

        while (true) {
            System.out.println("\nWhat would you like to do with this list of cars?");
            for (Act en : Act.values()) {
                System.out.println("- " + en);
            }

            String answ = sc.nextLine().trim().toUpperCase();

            try {
                Act selact = Act.valueOf(answ);

                switch (selact) {
                    case SORT:
                        Sort.sortMenu();
                        printCars();
                        break;
                    case LIST:
                    System.out.println("Amount of cars: " + workingList.size());    
                    printCars(workingList);

                        break;
                    // case EDIT:
                    // System.out.println("Enter the ID of the car to edit:");
                    // String editId = sc.nextLine();
                    // Car carToEdit = findCarById(editId);
                    // if (carToEdit != null) {
                    // Edit.edit(carToEdit);
                    // System.out.println("\nUpdated list:");

                    // } else {
                    // System.out.println("No car found with that ID.");
                    // }
                    // break;

                    case DELETE:
                        System.out.println("Enter the ID of the car to delete:");
                        String deleteId = sc.nextLine();
                        Delete.delete(deleteId, workingList); // delete from working list
                        System.out.println("\nUpdated list:");
                        printCars(workingList); // print updated working list
                        // if(workingList!=Car.getCarList()){
                        // System.out.println("Would you Like to change the list?");
                        // }

                        break;

                    case CREATE:
                        Create.create(workingList);
                        break;
                    case EXIT:
                        
                        System.err.println("\n");
                       
                            System.out.println("Would you like to save the changes? (yes/no)");
                            String save = sc.nextLine().trim();

                            if (save.equalsIgnoreCase("yes")) {
                                Car.getCarList().clear();
                                Car.getCarList().addAll(workingList);
                                CSVReader.clearCSV("CarStoreListings_Team12\\cars.csv");
                                CSVReader.appendCarToCSV();
                                for (Car car : Car.getCarList()) {
                                    CSVReader.appendCarToCSV(car);
                                }
                                System.out.println("Changes saved.");
                            } else {
                                System.out.println("Changes discarded.");
                            }
                        
                        printCars();
                        return;
                    case SEARCH:
                        Search.searchMenu(workingList);
                        break;

                    case FILTER:
                        Filter.filterMenu(workingList);
                        break;
                    default:
                        System.out.println("Option not implemented yet.");
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void printCars() {
        for (Car car : Car.getCarList()) {
            System.out.println(car);
        }
    }

    public static void printCars(ArrayList<Car> list) {
        for (Car car : list) {
            System.out.println(car);
        }
    }

    public static Car findCarById(String id) {
        for (Car car : Car.getCarList()) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }
}
