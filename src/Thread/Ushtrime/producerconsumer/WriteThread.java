package Thread.Ushtrime.producerconsumer;

public class WriteThread extends Thread {

    private Box box;

    public WriteThread(Box box) {
        this.box = box;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            box.write(i);
        }
        box.write(Box.SENTINEL);
    }

}
