package acts.act11;

public class ToyRobot extends LoudToy implements Rechargeable {
    private int chargeLevel;
    private int volume;

    public ToyRobot() {
        super(10);
        this.chargeLevel = chargeLevel;
    }

    @Override
    public void recharge() {
        chargeLevel = MAX_CHARGE;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public int getCharge() {
        // TODO Auto-generated method stub
        return chargeLevel;
    }
    public void setVolume(int volume) {
        this.volume = volume;
        makeNoise();
    }

    @Override
    public void makeNoise() {
        System.out.println("Beep Beep!");
    }
}
