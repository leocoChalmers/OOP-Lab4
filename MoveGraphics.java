import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MoveGraphics{
    private Map<Vehicle, Point> vehiclePositions = new HashMap<>();
    public MoveGraphics() {}

    public void moveit(int x, int y, Vehicle vehicle) {
        vehiclePositions.put(vehicle, new Point(x, y));
    }

    public Map<Vehicle, Point> getVehiclePositions() {
        return vehiclePositions;
    }
}
