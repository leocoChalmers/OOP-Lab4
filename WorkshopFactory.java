public class WorkshopFactory {
    Workshop getWorkshop(String type, int spotsAvailable, double startX, double startY) {
        return switch (type) {
            case "Saab95" -> new Saab95Workshop(spotsAvailable,new double[]{startX, startY});
            case "Car" -> new Workshop(spotsAvailable, new double[]{startX, startY});
            default -> null;
        };
    }
}
