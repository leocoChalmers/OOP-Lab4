import java.awt.*;

public class CarTransport<T extends IsCar> extends Vehicle implements Loadable<T>, IsTruck
{
    private int bedAngle;
    IsCar[] vehicleSpots = new IsCar[5];
    public CarTransport(double[] startingPosition, int id) {
        super("CarTransport", 2, Color.blue, 630, startingPosition, id);
    }

    @Override
    public void raiseBedAngle(){
        if (bedAngle == 0 && getCurrentSpeed() == 0.0){
            bedAngle = 70;
        }
    }
    @Override
    public void lowerBedAngle(){
        if (bedAngle == 70 && getCurrentSpeed() == 0.0){
            bedAngle = 0;
        }
    }

    @Override
    public void loadVehicle(T vehicle) {
        if (bedAngle == 70 && vehicle.getModelName() != "CarTransport") {
            if (Math.abs(vehicle.getPosition()[0]-getPosition()[0])<=10 && Math.abs(vehicle.getPosition()[1]-getPosition()[1])<=10){
                for (int i = 0; i < vehicleSpots.length; i++){
                    if (vehicleSpots[i] == null){
                        vehicleSpots[i] = vehicle;
                        return;
                    }
                }
            }
        }
    }

   /* @Override
    public void unloadVehicle(){
        if (bedAngle == 70){
            for (int i = vehicleSpots.length-1; i >= 0; i--){
                if (vehicleSpots[i] != null){
                    vehicleSpots[i].getPosition()[0] = getPosition()[0]-10-i;
                    vehicleSpots[i].getPosition()[1] = getPosition()[1]-10-i;
                    vehicleSpots[i] = null;
                    return;
                }
            }
        }
    }*/


    @Override
    public void move(){
        super.move();
        for (IsCar carSpot : vehicleSpots) {
            carSpot.setPosition(getPosition());
            return;
        }
    }

    @Override
    public int getBedAngle() {
        return bedAngle;
    }

    @Override
    public void setBedAngle(int angle) {
        bedAngle = angle;
    }

    @Override
    public void gas(double amount){
        if (getBedAngle() == 0) {
            super.gas(amount);
        }
        else {
            throw new IllegalArgumentException("bedAngle is not 0");
        }
    }
    @Override
    public void startEngine(){
        if (bedAngle ==0){
            super.startEngine();
        }
    }
}
