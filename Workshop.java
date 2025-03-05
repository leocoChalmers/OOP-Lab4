import java.util.ArrayList;

public class Workshop<T extends IsCar> implements Loadable<T> {
    private ArrayList<T> vehicleSpots = new ArrayList<>();
    protected int spotsAvailable;
    private double[] position;

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
            System.out.println(vehicleSpots.getFirst().getModelName());
            vehicleSpots.removeFirst();
        }
        else{
            System.out.println("No car in the workshop");
        }
    }
    public boolean isInWorkshop(Vehicle _vehicle){
        for(T vehicle: vehicleSpots){
            Vehicle v = (Vehicle)vehicle;
            if (v.getId() == _vehicle.getId())
                return true;
        }
        return false;
    }
}
