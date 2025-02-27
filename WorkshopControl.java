import java.util.ArrayList;

public class WorkshopControl {
    private ArrayList<Workshop> workshops = new ArrayList<>();

    public WorkshopControl() {
        workshops.add(new Saab95Workshop(5, new double[]{200, 300}));
    }

    public void handleVehicles(VehicleControl vehicleControl) {
        for (Workshop workshop : workshops) {
            for (Vehicle vehicle : vehicleControl.getVehicles()) {
                if (isNearWorkshop(vehicle, workshop)){
                    if (workshop.getAvailableSpots() > 0) {
                        workshop.loadVehicle(IsCar.class.cast(vehicle));
                        vehicle.stopEngine();
                    }
                }
            }
        }
    }
    private boolean isNearWorkshop(Vehicle vehicle, Workshop workshop){
        return Math.abs(vehicle.getPosition()[0] - workshop.getPosition()[0]) < 10
                && Math.abs(vehicle.getPosition()[1] - workshop.getPosition()[1]) < 10;
    }
    public ArrayList<Workshop> getWorkshops() {
        return workshops;
    }
}