import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Controller extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    ModelInterface carC;
    MoveGraphics moveGraphics = new MoveGraphics();
    View view = new View(X, Y-240, moveGraphics);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    private static final int maximumCars = 10;

    Random rand = new Random();
    String[] options = {"Saab95", "Volvo240", "Scania", "Random"};
    JComboBox<String> vehicleOptions = new JComboBox<>(options);

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Lift Bed");
    JButton lowerBedButton = new JButton("Lower Bed");
    JButton turnRightButton = new JButton("Turn Right");
    JButton turnLeftButton = new JButton("Turn left");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addButton = new JButton("Add vehicle");
    JButton removeButton = new JButton("Remove vehicle");

    public Controller(String framename, Model cc){
        this.carC = cc;
        initComponents(framename);
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(view);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        10);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(turnLeftButton, 6);
        controlPanel.add(turnRightButton, 7);
        controlPanel.add(addButton, 8);
        controlPanel.add(removeButton,9);
        controlPanel.add(vehicleOptions,10);

        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {carC.gas(gasAmount);}
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.brake(gasAmount);}
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.turboOn();}
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.turboOff();}
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.liftBed();}
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.lowerBed();}
        });

        turnRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.turnRight();}
        });

        turnLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.turnLeft();}
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.start();}
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {carC.stop();}
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {carC.addVehicle((String)vehicleOptions.getSelectedItem(),rand.nextInt(600),rand.nextInt(400));}
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {carC.removeVehicle();}
        });

        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}