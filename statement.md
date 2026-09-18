import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize modular and clean implementation
        List<VenueFacility> facilities = new ArrayList<>();
        facilities.add(new GoKartTrack("Pro Track 1", 1, 101));
        facilities.add(new GoKartTrack("Pro Track 2", 1, 102));
        facilities.add(new BowlingAlley("Family Lane 1", 6, 1, true));
        
        QueueSimulator simulator = new QueueSimulator(facilities);
        BillingEngine billing = new BillingEngine();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Smart Entertainment Venue Manager");

        while (running) {
            System.out.println("\n1. Register Customer to Waitlist");
            System.out.println("2. Process Queue & Assign Facilities");
            System.out.println("3. Checkout Customer & Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Party Size: ");
                    int size = scanner.nextInt();
                    simulator.addCustomerToQueue(new Customer(name, size));
                    break;
                case 2:
                    simulator.processQueue();
                    break;
                case 3:
                    System.out.println("Active Facilities:");
                    for (int i = 0; i < facilities.size(); i++) {
                        if (!facilities.get(i).isAvailable()) {
                            System.out.println(i + ": " + facilities.get(i).getFacilityName() + " (Occupied by " + facilities.get(i).getCurrentCustomer().getName() + ")");
                        }
                    }
                    System.out.print("Select facility index to checkout (-1 to cancel): ");
                    int checkoutIndex = scanner.nextInt();
                    if (checkoutIndex >= 0 && checkoutIndex < facilities.size()) {
                        VenueFacility fac = facilities.get(checkoutIndex);
                        if (!fac.isAvailable()) {
                            double amount = billing.calculateFinalBill(fac, true); // Assuming peak hour for demo
                            billing.printInvoice(fac, amount);
                            fac.releaseFacility();
                        } else {
                            System.out.println("Facility is already empty.");
                        }
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting System...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}