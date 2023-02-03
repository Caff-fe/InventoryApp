import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        Person john = new Person("John", "Owner");

        Inventory inv = new Inventory("Snickers", 0.70, 30);

        int invSize = 10;
        Inventory[] a = new Inventory[invSize];

        a[0] = inv;
        a[1] = new Inventory("Kitkat", 1.20, 0.340);
        a[2] = new Inventory("Mars", 1.40, 0.360);
        a[3] = new Inventory("Fanta", 1.60, 0.500);
        a[4] = new Inventory("Cola", 1.60, 0.500);
        a[5] = new Inventory("Water", 1.00, 0.500);
        a[6] = new Inventory("Bread", 1.50, 0.800);
        a[7] = new Inventory("Chocolate", 1.80, 0.750);
        a[8] = new Inventory("Soda", 1.2, 0.500);
        a[9] = new Inventory("Sprite", 1.6, 0.500);

        for (Inventory inventory : a) {
            System.out.println(inventory);
        }


        Person jack = new Person("Jack", "Delivery");
        System.out.println(jack.getPosition());
        System.out.println("");

        boolean isDone = false;



        List<Inventory> container = new ArrayList<>();
        int testIndex = 0;
        HashMap<String, Integer> cont = new HashMap<>();
        for (Inventory inventory : a) {
            if (inventory == null) {
                break;
            }
            container.add(inventory);
            testIndex++;
            cont.put(inventory.getProductName(), testIndex);


        }
        System.out.println("Welcome to the inventory");
        String test = login();
        int input = 0;
        input = getInput(scan);
        if (test.equalsIgnoreCase("admin")) {
            adminActions(scan, container, isDone, input);
        } else if (test.equalsIgnoreCase("delivery")) {
            deliveryActions(scan, container, isDone, input);
        } else if (test.equalsIgnoreCase("customer")) {
            customerActions(scan, container, isDone, input);
        } else {
            System.out.println("Invalid user ");
        }






//        adminActions(scan, container, isDone, input);
    }

    private static void adminActions(Scanner scan, List<Inventory> container, boolean isDone, int input) {
        while (!isDone) {
            if (input == 1) {
                addItem(scan, container);
                displayInv(container);
                menuAdmin();
                input = Integer.parseInt(scan.nextLine());
            } else if (input == 2) {
                displayInv(container);
                menuAdmin();
                input = Integer.parseInt(scan.nextLine());
            } else if (input == 3) {
                isDone = true;
            } else if (input == 4) {
                removeItem(scan, container);
                menuAdmin();
                input = Integer.parseInt(scan.nextLine());
            } else {
                System.out.println("Invalid integer");
                input = Integer.parseInt(scan.nextLine());
            }
        }
    }
    private static void deliveryActions(Scanner scan, List<Inventory> container, boolean isDone, int input) {
        while (!isDone) {
            if (input == 1) {
                addItem(scan, container);
                displayInv(container);
                menuDelivery();
                input = Integer.parseInt(scan.nextLine());
            } else if (input == 2) {
                displayInv(container);
                menuDelivery();
                input = Integer.parseInt(scan.nextLine());
            } else if (input == 3) {
                isDone = true;
            } else {
                System.out.println("Invalid integer");
                input = Integer.parseInt(scan.nextLine());
            }
        }
    }

    private static void customerActions(Scanner scan, List<Inventory> container, boolean isDone, int input) {
        while (!isDone) {
            if (input == 1) {
                displayInv(container);
                menuCustomer();
                input = Integer.parseInt(scan.nextLine());
            } else if (input == 2) {
                isDone = true;
            } else if (input == 3) {
                removeItem(scan, container);
                menuCustomer();
                input = Integer.parseInt(scan.nextLine());
            } else {
                System.out.println("Invalid integer");
                input = Integer.parseInt(scan.nextLine());
            }
        }
    }

    private static int getInput(Scanner scan) {
        int input = 0;
        try {
            input = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Invalid integer");
            getInput(scan);
        }
        return input;
    }

    private static void removeItem(Scanner scan, List<Inventory> container) {
        int removeIndex;
        System.out.println("Pick the index of the item you want to remove");
        removeIndex = Integer.parseInt(scan.nextLine());
        System.out.println(container.get(removeIndex) + " You removed this item");
        container.remove(removeIndex);
    }



    private static void addItem(Scanner scan, List<Inventory> container) {
        System.out.println("PLease input product Name, price and weight");

        String prodName = scan.nextLine();
        double price = Double.parseDouble(scan.nextLine());
        double weight = Double.parseDouble(scan.nextLine());

        container.add(container.size(), new Inventory(prodName, price, weight));
    }

    private static void displayInv(List<Inventory> container) {
        int indexCheck = -1;
        for (Inventory inventory : container) {
            if (inventory == null) {
                break;
            }
            indexCheck++;
            System.out.println(inventory + " at index " + indexCheck);
        }
    }

    static void menuAdmin() {
        System.out.println("Choose an option: ");
        System.out.println("1 - Add item ");
        System.out.println("2 - Display availability ");
        System.out.println("3 - Close application ");
        System.out.println("4 - Remove item");
    }

    static void menuDelivery() {
        System.out.println("Choose an option: ");
        System.out.println("1 - Add items ");
        System.out.println("2 - Display availability ");
        System.out.println("3 - Close application ");
    }

    static void menuCustomer() {
        System.out.println("Choose an option: ");
        System.out.println("1 - Display availability ");
        System.out.println("2 - Close application ");
        System.out.println("3 - Get item ");
    }

    static @NotNull String login() {
        System.out.println("Enter password: ");
        Scanner scan = new Scanner(System.in);
        String login = scan.nextLine();
        if (login.equalsIgnoreCase("admin")) {
            menuAdmin();
        } else if (login.equalsIgnoreCase("delivery")) {
            menuDelivery();
        } else if (login.equalsIgnoreCase("customer")) {
            menuCustomer();
        } else {
            System.out.println("Invalid user, please try again: ");
        }
        return login;
    }


}

