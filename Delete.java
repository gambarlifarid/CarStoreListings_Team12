import java.util.ArrayList;

public class Delete {
    private static ArrayList<Car> deletedCars = new ArrayList<>();

    public static void delete(String idToDelete, ArrayList<Car> workingList) {
        Car toRemove = null;
        for (Car c : workingList) {
            if (c.getId().equals(idToDelete)) {
                toRemove = c;
                break;
            }
        }

        if (toRemove != null) {
            deletedCars.add(toRemove);      // keep track of deleted items
            workingList.remove(toRemove);   // modify working copy
            System.out.println("Car with ID " + idToDelete + " deleted from working list.");
        } else {
            System.out.println("No car found with ID " + idToDelete + ".");
        }
    }

    public static ArrayList<Car> getDeletedCars() {
        return deletedCars;
    }
}