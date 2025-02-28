import java.awt.*;

public class MoveGraphics  implements VehicleObserver{
    public MoveGraphics() {

    }
     updatedVehicle();

    Point moveit(int x, int y, Vehicle vehicle, Point point) {
        point.x = x;
        point.y = y;
        return point;
    }
}
