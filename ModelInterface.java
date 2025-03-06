public interface ModelInterface {
    void gas(int amount);
    void brake(int amount);
    void turboOn();
    void turboOff();
    void liftBed();
    void lowerBed();
    void turnRight();
    void turnLeft();
    void start();
    void stop();
    void addVehicle(String model, double startingX, double startingY);
    void removeVehicle();
}
