import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class View extends JPanel{
    Model model = new Model();
    Map<String,BufferedImage> imageMap = new HashMap<>();

    BufferedImage volvoImage;

    BufferedImage saab95Image;

    BufferedImage scaniaImage;

    BufferedImage saab95WorkshopImage;
    protected Point saab95WorkshopPoint = new Point (200, 300);

    public View(int x, int y, MoveGraphics moveGraphics) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));

        try {
            volvoImage = ImageIO.read(View.class.getResourceAsStream("pics/Volvo240.jpg"));
            saab95Image = ImageIO.read(View.class.getResourceAsStream("pics/Saab95.jpg"));
            saab95WorkshopImage = ImageIO.read(View.class.getResourceAsStream("pics/Saab.png"));
            scaniaImage = ImageIO.read(View.class.getResourceAsStream("pics/Scania.jpg"));

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
           for(Vehicle vehicle: model.vehicleModel.getVehicles()){
               System.out.println(vehicle.getPosition()[1]);
               g.drawImage(imageMap.get(vehicle.getModelName()),(int)vehicle.getPosition()[0],(int)vehicle.getPosition()[1],100,50,null);
           }
        g.drawImage(saab95WorkshopImage, saab95WorkshopPoint.x, saab95WorkshopPoint.y, 100,50, null);
    }
}
