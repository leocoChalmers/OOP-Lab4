import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarController implements CarControllerController {
    WorkshopControl workshopControl = new WorkshopControl();

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    CarView frame;

    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.drawPanel.getVehicleControl().moveVehicles(frame);
            workshopControl.handleVehicles(frame.drawPanel.getVehicleControl());
            frame.drawPanel.repaint();
        }
    }

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
