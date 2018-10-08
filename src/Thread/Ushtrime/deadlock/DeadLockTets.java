package Thread.Ushtrime.deadlock;

public class DeadLockTets {
    public static void main(String[] args) {
        Sync sync = new Sync();
        CheckAvailable checkAvailable = new CheckAvailable(sync);

        ReleaseAvailable releaseAvailable = new ReleaseAvailable(sync);

        releaseAvailable.start();
        checkAvailable.start();

    }
}
