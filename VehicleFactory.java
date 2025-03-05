import java.awt.*;

public class VehicleFactory {
    private int id = 0;
    Vehicle getVehicle(String modelname, double startX, double startY) {
        switch (modelname) {
            case "Saab95":
                id++;
                return new Saab95(new double[]{startX, startY}, id);
            case "Volvo240":
                id++;
                return new Volvo240(new double[]{startX, startY}, id);
            case "Scania":
                id++;
                return new Scania(new double[]{startX, startY}, id);
            default:
                return null;
        }
    }
}
