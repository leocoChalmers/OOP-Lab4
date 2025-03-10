
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Model implements ModelInterface {
    WorkshopModel workshopModel = new WorkshopModel();
    VehicleModel vehicleModel = new VehicleModel();

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    Controller frame;

    public static void main(String[] args) {
        Model cc = new Model();
        cc.frame = new Controller("CarSim 1.0", cc);
        cc.timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vehicleModel.moveVehicles(frame.getWidth(),frame.getHeight());
            workshopModel.handleVehicles(vehicleModel.getVehicles());
            frame.view.repaint();
        }
    }

    public VehicleModel getVehicleModel(){
        return vehicleModel;
    }
    public WorkshopModel getWorkshopModel(){return workshopModel;}

    @Override
    public void gas(int amount) {vehicleModel.gas(amount);}
    @Override
    public void brake(int amount) {vehicleModel.brake(amount);}
    @Override
    public void turboOn(){vehicleModel.turboOn();}
    @Override
    public void turboOff(){
        vehicleModel.turboOff();
    }
    @Override
    public void liftBed(){
        vehicleModel.liftBed();
    }
    @Override
    public void lowerBed(){
        vehicleModel.lowerBed();
    }
    @Override
    public void turnRight(){vehicleModel.turnRight();}
    @Override
    public void turnLeft(){
        vehicleModel.turnLeft();
    }
    @Override
    public void start() {vehicleModel.start(workshopModel.getWorkshops());}
    @Override
    public void stop(){vehicleModel.stop();}
    @Override
    public void addVehicle(String model, double startingX, double startingY){vehicleModel.addVehicle(model, startingX, startingY);}
    @Override
    public void removeVehicle(){
        vehicleModel.removeVehicle();
    }
}
