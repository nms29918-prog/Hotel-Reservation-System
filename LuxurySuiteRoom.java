public class LuxurySuiteRoom extends SuiteRoom {
    private boolean butlerService;

    public LuxurySuiteRoom(int roomNumber, double pricePerNight, boolean hasJacuzzi, boolean butlerService) {
        super(roomNumber, pricePerNight, hasJacuzzi);
        this.butlerService = butlerService;
    }

    
    public double calculateCost(int nights) {
        double totalCost = super.calculateCost(nights); // تكلفة السويت الأساسية مع الجاكوزي
        if (butlerService) {
            totalCost += 200 * nights; // رسوم خدمة الخادم الشخصي الإضافية
        }
        return totalCost;
    }

    public boolean isButlerService() {
        return butlerService;
    }

    public void setButlerService(boolean butlerService) {
        this.butlerService = butlerService;
    }
}