import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class View extends JPanel{
    //Model model = new Model();
    Map<String,BufferedImage> vehicleImageMap = new HashMap<>();
    Map<String,BufferedImage> workshopImageMap = new HashMap<>();

    ModelInterface model;
    BufferedImage volvoImage;

    BufferedImage saab95Image;

    BufferedImage scaniaImage;

    BufferedImage saab95WorkshopImage;

    public View(int x, int y, ModelInterface model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.model = model;
        try {
            volvoImage = ImageIO.read(View.class.getResourceAsStream("pics/Volvo240.jpg"));
            saab95Image = ImageIO.read(View.class.getResourceAsStream("pics/Saab95.jpg"));
            saab95WorkshopImage = ImageIO.read(View.class.getResourceAsStream("pics/Saab.png"));
            scaniaImage = ImageIO.read(View.class.getResourceAsStream("pics/Scania.jpg"));

            vehicleImageMap.put("Volvo240",volvoImage);
            vehicleImageMap.put("Saab95",saab95Image);
            vehicleImageMap.put("Scania",scaniaImage);

            workshopImageMap.put("Saab95Workshop", saab95WorkshopImage);
        } catch (IOException ex)
        {
           ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
           for(Vehicle vehicle: model.getVehicleModel().getVehicles()){
               System.out.println(vehicle.getPosition()[1]);
               g.drawImage(vehicleImageMap.get(vehicle.getModelName()),(int)vehicle.getPosition()[0],(int)vehicle.getPosition()[1],100,50,null);
           }
           for(Workshop workshop: model.getWorkshopModel().getWorkshops()){
               g.drawImage(workshopImageMap.get(workshop.getClass().getSimpleName()),(int)workshop.getPosition()[0],(int)workshop.getPosition()[1],100,50,null);
           }
    }
}
