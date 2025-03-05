import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements CarControllerController {
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
            frame.drawPanel.getVehicleControl().moveVehicles(frame);
            workshopControl.handleVehicles(frame.drawPanel.getVehicleControl());
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    @Override
    public void gas(int amount) {
        frame.drawPanel.getVehicleControl().gas(amount);
    }
    @Override
    public void brake(int amount) {
        frame.drawPanel.getVehicleControl().brake(amount);
    }
    @Override
    public void turboOn(){
        frame.drawPanel.getVehicleControl().turboOn();
    }
    @Override
    public void turboOff(){
        frame.drawPanel.getVehicleControl().turboOff();
    }
    @Override
    public void liftBed(){
        frame.drawPanel.getVehicleControl().liftBed();
    }
    @Override
    public void lowerBed(){
        frame.drawPanel.getVehicleControl().lowerBed();
    }
    @Override
    public void turnRight(){
        frame.drawPanel.getVehicleControl().turnRight();
    }
    @Override
    public void turnLeft(){
        frame.drawPanel.getVehicleControl().turnLeft();
    }
    @Override
    public void start() {
        frame.drawPanel.getVehicleControl().start(workshopControl);
    }
    @Override
    public void stop(){
        frame.drawPanel.getVehicleControl().stop();
    }

    @Override
    public void addVehicle(String model, double startingX, double startingY){
        frame.drawPanel.getVehicleControl().addVehicle(model, startingX, startingY);
    }
    @Override
    public void removeVehicle(){
        frame.drawPanel.getVehicleControl().removeVehicle();
    }
}
