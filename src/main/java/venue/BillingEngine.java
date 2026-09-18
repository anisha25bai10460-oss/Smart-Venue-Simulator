package venue;

public class BillingEngine {
    private static final double PEAK_HOUR_MULTIPLIER = 1.5;

    public double calculateFinalBill(VenueFacility facility, boolean isPeakHour) {
        double baseCost = facility.getBaseRate();
        Customer customer = facility.getCurrentCustomer();
        
        if (customer == null) {
            return 0.0;
        }

        double finalCost = baseCost;
        if (isPeakHour) {
            finalCost *= PEAK_HOUR_MULTIPLIER;
        }
        return finalCost;
    }

    public void printInvoice(VenueFacility facility, double amount) {
        System.out.println("====================================");
        System.out.println("INVOICE FOR: " + facility.getCurrentCustomer().getName());
        System.out.println("Facility Used: " + facility.getFacilityName());
        System.out.println("Total Amount Due: $" + String.format("%.2f", amount));
        System.out.println("====================================");
    }
}
