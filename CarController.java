import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements CarControllerController {
    VehicleControl vehicleControl = new VehicleControl();
    WorkshopControl workshopControl = new WorkshopControl();

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    CarView frame;

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vehicleControl.moveVehicles(frame);
            workshopControl.handleVehicles(vehicleControl);
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    @Override
    public void gas(int amount) {
        vehicleControl.gas(amount);
    }
    @Override
    public void brake(int amount) {
        vehicleControl.brake(amount);
    }
    @Override
    public void turboOn(){
        vehicleControl.turboOn();
    }
    @Override
    public void turboOff(){
        vehicleControl.turboOff();
    }
    @Override
    public void liftBed(){
        vehicleControl.liftBed();
    }
    @Override
    public void lowerBed(){
        vehicleControl.lowerBed();
    }
    @Override
    public void turnRight(){
        vehicleControl.turnRight();
    }
    @Override
    public void turnLeft(){
        vehicleControl.turnLeft();
    }
    @Override
    public void start() {
        vehicleControl.start(workshopControl);
    }
    @Override
    public void stop(){
        vehicleControl.stop();
    }
}
