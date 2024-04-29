public class Bee implements Runnable {
    private boolean isRunning = true;
    private int positionX;
    private int positionY;
    public final int WIDTH = 800;
    private boolean flag = true;
    Bee(int initialPositionX, int initialPositionY) {
        this.positionX = initialPositionX;
        this.positionY = initialPositionY;
    }
    int getPositionX() {return positionX;}
    int getPositionY() {return positionY;}

    void setPosition(int newPositionX, int newPositionY) {
        this.positionX = newPositionX;
        this.positionY = newPositionY;
    }
    void move() {
        if (flag) {
            setPosition(getPositionX() + 10,30);
            if (getPositionX() >= (WIDTH - 30)) flag = false;
        }
        else {
            setPosition(getPositionX() - 10, 30);
            if (getPositionX() <= 0) flag = true;
        }
    }
    public void stopMove() {
        isRunning = false;
    }
    @Override
    public void run() {
        while (isRunning) {
            move();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

