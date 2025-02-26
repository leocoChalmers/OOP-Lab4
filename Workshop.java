import java.util.ArrayList;

public class Workshop<T extends Car> implements Loadable<T> {
    private ArrayList<T> vehicleSpots = new ArrayList<>();
    protected int spotsAvailable;
    private double[] position = {0,0};

    public Workshop(int spotsAvailable, double[] position){
        this.spotsAvailable = spotsAvailable;
        this.position = position;
    }
    public int getAvailableSpots(){
        return spotsAvailable - vehicleSpots.size();
    }
    public double[] getPosition(){return position;}

    @Override
    public void loadVehicle(T vehicle){
        if(vehicleSpots.size() < spotsAvailable)
                vehicleSpots.add(vehicle);
        else
            System.out.println("No spots available");
    }
    public void unloadVehicle(){
        if (!vehicleSpots.isEmpty()) {
            System.out.println(vehicleSpots.getFirst().modelName);
            vehicleSpots.removeFirst();
        }
        else{
            System.out.println("No car in the workshop");
        }
    }
    public boolean isInWorkshop(Vehicle _vehicle){
        for(Vehicle vehicle: vehicleSpots){
            if (vehicle.getClass().equals(_vehicle.getClass()))
                return true;
        }
        return false;
    }
}
