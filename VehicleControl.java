/*public class ControlVehicle  {
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            try {
                vehicle.gas(gas);
            } catch (RuntimeException ignored) {}
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles)
            vehicle.brake(brake);
    }
    void turboOn(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOn();
        }
    }
    void turboOff(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOff();
        }
    }
    void liftBed(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania)
                ((Scania) vehicle).raiseBedAngle();
        }

    }
    void lowerBed(){
        for (Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania)
                ((Scania) vehicle).lowerBedAngle();
        }
    }
    void turnRight(){
        for (Vehicle vehicle : vehicles){
            vehicle.turnRight();
        }
    }
    void turnLeft(){
        for (Vehicle vehicle : vehicles){
            vehicle.turnLeft();
        }
    }
    void start() {
        for(Workshop workshop: workshops){
            for (Vehicle vehicle : vehicles) {
                if(!workshop.isInWorkshop(vehicle))
                    vehicle.startEngine();
            }
        }
    }
    void stop(){
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }
}*/
