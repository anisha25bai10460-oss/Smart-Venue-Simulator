package venue;

public class GoKartTrack extends VenueFacility {
    private int kartNumber;
    private String trackCondition;

    public GoKartTrack(String facilityName, int capacity, int kartNumber) {
        super(facilityName, capacity);
        this.kartNumber = kartNumber;
        this.trackCondition = "Optimal";
    }

    @Override
    public double getBaseRate() {
        return 15.0; // $15 per session
    }

    public int getKartNumber() { return kartNumber; }
}