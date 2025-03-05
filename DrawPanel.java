import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DrawPanel extends JPanel{

    Map<String,BufferedImage> imageMap = new HashMap<>();

    BufferedImage volvoImage;

    BufferedImage saab95Image;

    BufferedImage scaniaImage;

    BufferedImage saab95WorkshopImage;
    protected Point saab95WorkshopPoint = new Point (200, 300);

    private VehicleControl vehicleControl;
    private MoveGraphics moveGraphics;

    void moveit(int x, int y, Vehicle vehicle){
        moveGraphics.moveit(x,y,vehicle);
    }


    public DrawPanel(int x, int y, VehicleControl vehicleControl, MoveGraphics moveGraphics) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));

        this.vehicleControl = vehicleControl;
        this.moveGraphics = moveGraphics;

        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
