import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    Map<String,BufferedImage> imageMap = new HashMap<>();

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    // To keep track of a single car's position
    protected Point volvoPoint = new Point(0,100);

    BufferedImage saab95Image;
    protected Point saab95Point = new Point(0,0);

    BufferedImage scaniaImage;
    protected Point scaniaPoint = new Point(0, 200);

    BufferedImage saab95WorkshopImage;
    protected Point saab95WorkshopPoint = new Point (200, 300);

    private VehicleControl vehicleControl;
    private MoveGraphics moveGraphics;

    // TODO: Make this general for all cars
    void moveit(int x, int y, Vehicle vehicle){
        moveGraphics.moveit(x,y,vehicle);
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, VehicleControl vehicleControl, MoveGraphics moveGraphics) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));

        this.vehicleControl = vehicleControl;
        this.moveGraphics = moveGraphics;
        // Print an error message in case file is not found with a try/catch block

        try {

            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            //volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            saab95WorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab.png"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

            imageMap.put("Volvo240",volvoImage);
            imageMap.put("Saab95",saab95Image);
            imageMap.put("Scania",scaniaImage);
        } catch (IOException ex)
        {
           ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        //vehicleControl.getVehicles().forEach(vehicle -> {
          // g.drawImage(imageMap.get(vehicle.getModelName()),moveGraphics.getVehiclePositions().get(vehicle).x,
            //       moveGraphics.getVehiclePositions().get(vehicle).y,100,50,null);
        //});

       moveGraphics.getVehiclePositions().forEach((_vehicle, position)->{
           for(Vehicle vehicle: vehicleControl.getVehicles()){
               if(vehicle.getId() == _vehicle.getId()){
                   g.drawImage(imageMap.get(vehicle.getModelName()),position.x,position.y,100,50,null);
               }
           }
        });
        
        g.drawImage(saab95WorkshopImage, saab95WorkshopPoint.x, saab95WorkshopPoint.y, 100,50, null);

    }
    VehicleControl getVehicleControl(){
        return vehicleControl;
    }
}
