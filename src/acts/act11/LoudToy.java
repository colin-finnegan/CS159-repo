package acts.act11;

public class LoudToy {

    private int volume;

    public LoudToy(int volume) {
        this.volume = 10;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        makeNoise();
    }

    public void makeNoise() {
        // will be overidden by subclass.
    }
}
