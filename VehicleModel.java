import java.util.ArrayList;

public class VehicleModel {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    VehicleFactory vehicleFactory = new VehicleFactory();
    public VehicleModel() {
        addVehicle("Saab95",0,0 );
        addVehicle("Volvo240",0, 100);
        addVehicle("Scania",0, 200);
    }
    public void addVehicle(String model, double startingX, double startingY){
        if(vehicles.size() < 10)
            vehicles.add(vehicleFactory.getVehicle(model, startingX, startingY));
    }
    public void removeVehicle(){
        if(!vehicles.isEmpty())
            vehicles.removeFirst();
    }

    public void moveVehicles(double frameDimensionX, double frameDimensionY) {//Ändra beroende
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getPosition()[0]);
            int y = (int) Math.round(vehicle.getPosition()[1]);
            if (isOutside(x, y, frameDimensionX, frameDimensionY)) {
                turnAround(vehicle);
            }
        }
    }

    private void turnAround(Vehicle vehicle) {
        vehicle.turnLeft();
        vehicle.turnLeft();
    }

    private boolean isOutside(int x, int y, double frameDimensionX, double frameDimensionY) {
        return y < 0 || y > frameDimensionY-63
                || x < 0 || x > frameDimensionX-117;
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            try {
                vehicle.gas(gas);
            } catch (RuntimeException ignored) {
            }
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
            vehicle.brake(brake);
    }

    void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOn();
        }
    }

    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOff();
        }
    }

    void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania)
                ((Scania) vehicle).raiseBedAngle();
        }

    }

    void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania)
                ((Scania) vehicle).lowerBedAngle();
        }
    }

    void turnRight() {
        for (Vehicle vehicle : vehicles) {
            vehicle.turnRight();
        }
    }

    void turnLeft() {
        for (Vehicle vehicle : vehicles) {
            vehicle.turnLeft();
        }
    }

    void start(WorkshopModel workshopModel) {
        for (Workshop workshop : workshopModel.getWorkshops()) {
            for (Vehicle vehicle : vehicles) {
                if (!workshop.isInWorkshop(vehicle))
                    vehicle.startEngine();
            }
        }
    }
    void stop(){
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
