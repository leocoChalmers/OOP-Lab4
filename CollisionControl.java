public class CollisionControl {
    private Vehicle vehicle;
    private int frameHeight ;
    private int frameWidth;

    public CollisionControl(Vehicle vehicle, int frameHeight, int frameWidth) {
        this.vehicle = vehicle;
        this.frameHeight = frameHeight;
        this.frameWidth = frameWidth;
    }
    public Vehicle IsOutside(){
        int x = (int) Math.round(vehicle.getPosition()[0]);
        int y = (int) Math.round(vehicle.getPosition()[1]);
        if(y < 0 || y > frameHeight || x < 0 || x > frameWidth){
            vehicle.turnLeft();
            vehicle.turnLeft();
            while (IsOutside) {
                vehicle.move();
            }
            vehicle.stopEngine();
            vehicle.startEngine();

        }
        return true;
    }
    }
}
