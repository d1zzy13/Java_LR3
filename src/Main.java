public class Main {
    public static void main(String[] args) {

        int numBees = Integer.parseInt(args[0]);
        int numDrones = Integer.parseInt(args[1]);
        Simulation simulation = new Simulation(numBees, numDrones);
        Thread thread = new Thread(simulation);
        thread.start();

        try{
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        simulation.stopSimulation();
        System.exit(0);
    }
}
