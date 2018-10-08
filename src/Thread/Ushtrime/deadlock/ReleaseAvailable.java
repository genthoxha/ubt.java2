package Thread.Ushtrime.deadlock;


public class ReleaseAvailable extends Thread {

    private Sync syncObject;

    public ReleaseAvailable(Sync syncObject) {
        this.syncObject = syncObject;
        setPriority(Thread.MAX_PRIORITY);
    }

    public void run() {
        System.out.println("ReleaseAvailable Start");
        syncObject.release();
        System.out.println("ReleaseAvailable End");

    }

}
