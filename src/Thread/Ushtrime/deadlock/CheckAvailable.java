package Thread.Ushtrime.deadlock;

public class CheckAvailable extends Thread {

    private Sync syncObject;

    public CheckAvailable(Sync syncObject) {
        this.syncObject = syncObject;
    }

    public void run() {
        System.out.println("CheckAvailable start");
        syncObject.check();
    }

}
