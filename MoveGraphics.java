import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MoveGraphics  implements VehicleObserver{
    private Map<Vehicle, Point> vehiclePositions = new HashMap<>();
    public MoveGraphics() {

    }
    public void updatedVehicle(Vehicle vehicle){
    }

    public void moveit(int x, int y, Vehicle vehicle) {
        System.out.println("Hep");
        vehiclePositions.put(vehicle, new Point(x, y));
    }

    public Map<Vehicle, Point> getVehiclePositions() {
        return vehiclePositions;
    }
}
