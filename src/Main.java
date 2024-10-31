import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Main class to execute the program for managing planes.
 * It allows the user to enter details of planes, display the list,
 * sort them by speed and year, and search for a specific plane.
 */
public class Main {
    /**
     * Main method to run the program. It collects planes' details,
     * sorts them by speed and year, displays them, and allows searching for a plane.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inputting the number of planes in the array
        System.out.print("Введіть кількість літаків: ");
        int planesNumber = scanner.nextInt();
        scanner.nextLine();

        // Creating the array
        Plane[] planes = new Plane[planesNumber];

        // Inputting planes' characteristics
        for (int i = 0; i < planesNumber; i++) {
            System.out.println("\nВведіть характеристики літака " + (i + 1) + ":");
            planes[i] = getPlaneFromConsole(scanner);
        }

        // Printing the original array
        System.out.println("\nПовний масив літаків:");
        printAllPlanes(planes);

        // Sort planes by speed (ascending), and by year (descending) if speeds are equal
        Arrays.sort(planes, Comparator.comparing(Plane::getMaxSpeed)
                .thenComparing(Comparator.comparing(Plane::getYear).reversed()));
        System.out.println("\nЛітаки, відсортовані за зростанням швидкості та за спаданням року, якщо швидкість однакова:");
        printAllPlanes(planes);

        // Searching for the identical plane
        System.out.println("\nВведіть характеристики літака для пошуку:");
        Plane searchedPlane = getPlaneFromConsole(scanner);
        boolean found = false;
        for (int i = 0; i < planes.length; i++) {
            if (planes[i].isEqual(searchedPlane)) {
                found = true;
                System.out.println("Ідентичним є літак " + (i + 1));
                break;
            }
        }
        if (!found) {
            System.out.println("Ідентичний літак не знайдено");
        }

        scanner.close();
    }

    /**
     * Collects plane details from the console.
     *
     * @param scanner the scanner object used to read user input.
     * @return a new Plane object with the user's input.
     */
    private static Plane getPlaneFromConsole(Scanner scanner) {
        System.out.print("Назва: ");
        String name = scanner.nextLine();
        System.out.print("Рік створення: ");
        int year = scanner.nextInt();
        System.out.print("Вага (кг): ");
        double weight = scanner.nextDouble();
        System.out.print("Максимальна швидкість (км/год): ");
        double maxSpeed = scanner.nextDouble();
        System.out.print("Дальність польоту (км): ");
        double range = scanner.nextDouble();
        scanner.nextLine();

        return new Plane(name, year, weight, maxSpeed, range);
    }

    /**
     * Prints the details of each plane in an array.
     *
     * @param planes the array of Plane objects to print.
     */
    private static void printAllPlanes(Plane[] planes) {
        for (Plane plane : planes) {
            System.out.print(plane.getName() + " ");
            System.out.print(plane.getYear() + " ");
            System.out.print(plane.getWeight() + " ");
            System.out.print(plane.getMaxSpeed() + " ");
            System.out.println(plane.getRange());
        }
    }
}
