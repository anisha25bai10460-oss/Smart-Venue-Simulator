package venue;

public class BowlingAlley extends VenueFacility {
    private int laneNumber;
    private boolean shoeRentalIncluded;

    public BowlingAlley(String facilityName, int capacity, int laneNumber, boolean shoeRentalIncluded) {
        super(facilityName, capacity);
        this.laneNumber = laneNumber;
        this.shoeRentalIncluded = shoeRentalIncluded;
    }

    @Override
    public double getBaseRate() {
        return 25.0; // $25 per lane session
    }
}