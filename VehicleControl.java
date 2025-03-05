import java.util.ArrayList;

public class VehicleControl {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    VehicleFactory vehicleFactory = new VehicleFactory();
    public VehicleControl() {
        addVehicle("Saab95",0,0 );
        addVehicle("Volvo240",0, 100);
        addVehicle("Scania",0, 200);
        System.out.println("Nyskapad");
    }
    public void addVehicle(String model, double startingX, double startingY){
        System.out.println(vehicles.size());
        if(vehicles.size() < 10) {
            vehicles.add(vehicleFactory.getVehicle(model, startingX, startingY));
        }
    }
    public void removeVehicle(){
        if(!vehicles.isEmpty())
            vehicles.removeFirst();
    }

    public void moveVehicles(CarView frame) {
        //System.out.println(vehicles);
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getPosition()[0]);
            int y = (int) Math.round(vehicle.getPosition()[1]);

            if (isOutside(x, y, frame)) {
                turnAround(vehicle);
            }
            frame.drawPanel.moveit(x,y,vehicle);
            frame.drawPanel.repaint();
        }
    }

    private void turnAround(Vehicle vehicle) {
        vehicle.turnLeft();
        vehicle.turnLeft();
    }

    private boolean isOutside(int x, int y, CarView frame) {
        return y < 0 || y > frame.drawPanel.getHeight()-63
                || x < 0 || x > frame.drawPanel.getWidth()-117;
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

    void start(WorkshopControl workshopControl) {
        for (Workshop workshop : workshopControl.getWorkshops()) {
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
        //System.out.println(vehicles);
        return vehicles;
    }
}
