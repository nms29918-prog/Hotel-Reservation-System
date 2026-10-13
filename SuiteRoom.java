public class SuiteRoom extends Room {
    private boolean hasJacuzzi;

    public SuiteRoom(int roomNumber, double pricePerNight, boolean hasJacuzzi) {
        super(roomNumber, pricePerNight);
        this.hasJacuzzi = hasJacuzzi;
    }

        public double calculateCost(int nights) {
        double totalCost = pricePerNight * nights;
        if (hasJacuzzi) {
            totalCost += 150 * nights;
        }
        return totalCost;
    }

    public boolean isHasJacuzzi() {
        return hasJacuzzi;
    }

    public void setHasJacuzzi(boolean hasJacuzzi) {
        this.hasJacuzzi = hasJacuzzi;
    }
}