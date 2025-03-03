import java.awt.*;

public class VehicleFactory {
    Vehicle getVehicle(String modelname, double startX, double startY) {
        return switch (modelname) {
            case "Saab95" -> new Saab95(new double[]{startX, startY});
            case "Volvo240" -> new Volvo240(new double[]{startX, startY});
            case "Scania" -> new Scania(new double[]{startX, startY});
            case "CarTransport" -> new CarTransport(new double[]{startX, startY});
            default -> null;
        };
    }
}
