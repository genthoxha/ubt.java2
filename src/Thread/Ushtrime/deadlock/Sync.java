package Thread.Ushtrime.deadlock;

public class Sync {

    private boolean available = false;

    public synchronized void check() {
        while (!available) {
            System.out.println("Checking");
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException ie) {

            }
        }
    }

    public synchronized void release() {
        System.out.println("Releasing");
        available = true;
    }
}
