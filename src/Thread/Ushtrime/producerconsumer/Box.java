package Thread.Ushtrime.producerconsumer;

public class Box {
    private int value;
    public static final int SENTINEL = -999;
    private boolean hasValue = false;

    public synchronized void write(int v) {
        while (hasValue) {
            try {
                wait();
            } catch (InterruptedException ie) {

            }
        }
        value = v;
        hasValue = true;
        notify();
    }

    public synchronized int read() {
        while (!hasValue) {
            try {
                wait();
            } catch (InterruptedException ie) {

            }
        }
        hasValue = false;
        notify();
        return value;
    }
}
