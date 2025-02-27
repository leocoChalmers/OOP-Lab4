import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
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
    void gas(int amount) {
        vehicleControl.gas(amount);
    }
    void brake(int amount) {
        vehicleControl.brake(amount);
    }
    void turboOn(){
        vehicleControl.turboOn();
    }
    void turboOff(){
        vehicleControl.turboOff();
    }
    void liftBed(){
        vehicleControl.liftBed();
    }
    void lowerBed(){
        vehicleControl.lowerBed();
    }
    void turnRight(){
        vehicleControl.turnRight();
    }
    void turnLeft(){
        vehicleControl.turnLeft();
    }
    void start() {
        vehicleControl.start(workshopControl);
    }
    void stop(){
        vehicleControl.stop();
    }
}
