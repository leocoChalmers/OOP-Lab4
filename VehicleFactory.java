import java.awt.*;

public class VehicleFactory {
    Vehicle getVehicle(String modelname, double startX, double startY) {
        switch (modelname) {
            case "Saab95":
                return new Saab95(new double[]{startX, startY});
            case "Volvo240":
                return new Volvo240(new double[]{startX, startY});
            case "Scania":
                return new Scania(new double[]{startX, startY});
            default:
                return null;
        }
    }
}
