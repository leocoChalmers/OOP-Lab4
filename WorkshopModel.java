import java.util.ArrayList;

public class WorkshopModel {
    private ArrayList<Workshop> workshops = new ArrayList<>();
    WorkshopFactory workshopFactory = new WorkshopFactory();
    public WorkshopModel() {
        workshops.add(workshopFactory.getWorkshop("Saab95",5,200,300));
    }

    public void handleVehicles(ArrayList<Vehicle> vehicles) {
        for (Workshop workshop : workshops) {
            for (Vehicle vehicle : vehicles) {
                if (isNearWorkshop(vehicle, workshop)){
                    if (workshop.getAvailableSpots() > 0) {
                        try{
                            workshop.loadVehicle((IsCar) vehicle);
                            vehicle.stopEngine();
                        }
                        catch(Exception e){}
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