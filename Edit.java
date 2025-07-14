import java.util.Scanner;

public class Edit {
    public static void edit(Car c1) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which attribute would you like to edit?");
        for (Att a : Att.values()) {
            System.out.println("- " + a.name());
        }

        String input = sc.nextLine().toLowerCase().trim();
        try {
            Att selectedAtt = Att.valueOf(input);

            System.out.println("Enter the new value:");

            switch (selectedAtt) {
                case brand:
                    c1.setBrand(sc.nextLine());
                    break;
                case model:
                    c1.setModel(sc.nextLine());
                    break;
                case year:
                    c1.setYear(Integer.parseInt(sc.nextLine()));
                    break;
                case price:
                    c1.setPrice(Double.parseDouble(sc.nextLine()));
                    break;
                case millage:
                    c1.setMillage(Integer.parseInt(sc.nextLine()));
                    break;
                case fuel:
                    for (FuelType f : FuelType.values()) {
                        System.out.println("- " + f.name());
                    }
                    c1.setFuel(FuelType.valueOf(sc.nextLine().toUpperCase()));
                    break;
                case seller:
                    System.out.print("Enter seller name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter seller city: ");
                    String city = sc.nextLine();
                    System.out.print("Enter seller phone: ");
                    String phone = sc.nextLine();
                    c1.setSeller(new Seller(name, city, phone));
                    break;
            }

            System.out.println("Car updated successfully!\n" + c1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid attribute. Please try again.");
        }
    }
}
