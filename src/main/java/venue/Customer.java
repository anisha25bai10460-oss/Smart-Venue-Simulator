package venue;

public class Customer {
    private String name;
    private int partySize;
    private long checkInTime;

    public Customer(String name, int partySize) {
        this.name = name;
        this.partySize = partySize;
        this.checkInTime = System.currentTimeMillis();
    }

    public String getName() { return name; }
    public int getPartySize() { return partySize; }
    public long getCheckInTime() { return checkInTime; }
}