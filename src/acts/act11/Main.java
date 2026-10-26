package acts.act11;

public class Main {

    public static void main(String[] args) {

        LoudToy toy1 = new LoudToy(1);
        toy1.setVolume(5);

        LoudToy toy2 = new ToySheep();
        toy2.setVolume(5);

        LoudToy toy3 = new ToyRobot();
        toy3.setVolume(5);
    }
}
