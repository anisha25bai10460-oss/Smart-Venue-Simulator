package venue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueSimulator {
    private Queue<Customer> waitlist;
    private List<VenueFacility> facilities;

    public QueueSimulator(List<VenueFacility> facilities) {
        this.waitlist = new LinkedList<>();
        this.facilities = facilities;
    }

    public void addCustomerToQueue(Customer customer) {
        waitlist.add(customer);
        System.out.println(customer.getName() + " added to the waitlist.");
    }

    public void processQueue() {
        if (waitlist.isEmpty()) {
            System.out.println("Waitlist is empty.");
            return;
        }

        for (VenueFacility facility : facilities) {
            if (facility.isAvailable() && !waitlist.isEmpty()) {
                Customer nextCustomer = waitlist.peek();
                if (facility.assignCustomer(nextCustomer)) {
                    waitlist.poll(); // Remove from queue
                    System.out.println("Assigned " + nextCustomer.getName() + " to " + facility.getFacilityName());
                }
            }
        }
    }
}