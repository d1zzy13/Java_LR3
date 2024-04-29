import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Simulation extends Frame implements Runnable {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int objectWidth = 30;
    private final int objectHeight = 30;
    private boolean isRunning = true;
    private List<Bee> bees;
    private List<Drone> drones;
    private int numBees;
    private int numDrones;
    public Simulation(int numBees, int numDrones) {
        this.numBees = numBees;
        this.numDrones = numDrones;
        setTitle("Пчелы и трутни.");
        setSize(WIDTH, HEIGHT);
        setVisible(true);

        bees = new ArrayList<>();
        drones = new ArrayList<>();

        createThreads();
    }

    @Override
    public void run() {
        while (isRunning) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void createThreads() {
        for (int i = 0; i < numBees; i++) {
            bees.add(new Bee(30 - i * WIDTH/numBees, 30));
            Thread thread = new Thread(bees.get(i));
            thread.start();
        }

        for (int i = 0; i < numDrones; i++) {
            drones.add(new Drone(60 - i * WIDTH/numBees, 570));
            Thread thread = new Thread(drones.get(i));
            thread.start();
        }
    }
    public void stopSimulation() {
        for(Bee bee: bees) {
            bee.stopMove();
        }
        for(Bee drone: drones) {
            drone.stopMove();
        }
        isRunning = false;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLUE);
        for (Bee bee : bees) {
            g.fillOval(bee.getPositionX(), bee.getPositionY() , objectWidth, objectHeight);
        }

        g.setColor(Color.RED);
        for (Drone drone : drones) {
            g.fillOval(drone.getPositionX() , drone.getPositionY(), objectWidth, objectHeight);
        }
    }
}