import java.util.ArrayList;

public class Saab95Workshop extends Workshop {
    protected ArrayList<Saab95> vehicleSpots = new ArrayList<>();

    public Saab95Workshop(int spotsAvailable, double[] position) {
        super(spotsAvailable, position);

    }


    public void loadVehicle(Saab95 saab95) {
        if (spotsAvailable > 0) {
            vehicleSpots.add(saab95);
            spotsAvailable--;
        } else
            throw new IllegalArgumentException("Car is not saab95");
    }


}