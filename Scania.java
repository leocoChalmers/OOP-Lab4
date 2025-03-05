import java.awt.*;

public class Scania extends Vehicle implements IsTruck
{
    private int bedAngle;
    public Scania(double[] startingPosition, int id){
        super("Scania",2, Color.pink, 770, startingPosition, id);
        stopEngine();
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
    public void gas(double amount) {
        if (bedAngle == 0) {
            super.gas(amount);
        }
        else{
            throw new IllegalArgumentException("bedAngle is not 0");
        }
    }
    @Override
    public void startEngine(){
        if(bedAngle == 0){
            super.startEngine();
        }
    }
}
