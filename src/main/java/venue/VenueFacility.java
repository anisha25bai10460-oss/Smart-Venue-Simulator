package venue;

public abstract class VenueFacility {
    protected String facilityName;
    protected int capacity;
    protected boolean isAvailable;
    protected Customer currentCustomer;

    public VenueFacility(String facilityName, int capacity) {
        this.facilityName = facilityName;
        this.capacity = capacity;
        this.isAvailable = true;
    }

    public boolean isAvailable() { return isAvailable; }
    public String getFacilityName() { return facilityName; }
    public Customer getCurrentCustomer() { return currentCustomer; }

    public boolean assignCustomer(Customer customer) {
        if (isAvailable && customer.getPartySize() <= capacity) {
            this.currentCustomer = customer;
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    public void releaseFacility() {
        this.currentCustomer = null;
        this.isAvailable = true;
    }
    
    public abstract double getBaseRate();
}