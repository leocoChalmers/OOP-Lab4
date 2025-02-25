package lab2;

import java.awt.*;

public class Saab95 extends Car
{
    boolean turboOn;

    public Saab95(double[] startingPosition){
        super("Saab95", 2, Color.red, 125, startingPosition);
	    turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}
