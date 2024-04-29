import java.util.ArrayList;
import java.util.Random;

public class Drone extends Bee implements Runnable{
    private boolean flag = true;
    private final int WIDTH = 77;
    private final int HEIGHT = 57;
    ArrayList<Integer> randomCoord = new ArrayList<>();

    Drone(int initialPositionX, int initialPositionY) {
        super(initialPositionX, initialPositionY);
    }

    public void generateRandomCoord () {
        Random rand = new Random();
        int min = 3;
        int randomX = (rand.nextInt(WIDTH - min + 1) + min) * 10;
        int randomY = (rand.nextInt(HEIGHT - min + 1)+ min) * 10;
        this.randomCoord.add(randomX);
        this.randomCoord.add(randomY);
    }
    @Override
     void move() {
        if (flag) {
            generateRandomCoord();
            flag = false;
        }
        if(getPositionX() < this.randomCoord.get(0)) setPosition(getPositionX() + 10, getPositionY());
        else if(getPositionX() > this.randomCoord.get(0)) setPosition(getPositionX() - 10, getPositionY());
        if(getPositionY() < this.randomCoord.get(1)) setPosition(getPositionX(), getPositionY() + 10);
        else if (getPositionY() > this.randomCoord.get(1)) setPosition(getPositionX(), getPositionY() - 10);

        if ((getPositionX() == this.randomCoord.get(0)) && (getPositionY() == this.randomCoord.get(1))) {
            flag = true;
            this.randomCoord.clear();
        }

    }
}
