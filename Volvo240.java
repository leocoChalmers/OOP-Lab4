import java.awt.*;

public class Volvo240 extends Vehicle implements IsCar
{
    final static double trimFactor = 1.25;

    public Volvo240(double[] startingPosition, int id){
        super("Volvo240", 4,Color.black, 100, startingPosition, id);
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void setPosition(double[] newPosition) {
        position = newPosition;
    }
}
