import java.awt.*;

public class Scania extends Vehicle implements IsTruck
{
    private int bedAngle;
    public Scania(double[] startingPosition){
        super("Scania",2, Color.pink, 770, startingPosition);
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
        if (getBedAngle() == 0) {
            if (amount <= 1 && amount > 0)
                incrementSpeed(amount);
            else
                throw new IllegalArgumentException("Too much gas");
        }
        else{
                throw new IllegalArgumentException("bedAngle is not 0");
        }
    }
}
