package Thread.Ushtrime.producerconsumer;

public class ReadThread extends Thread {

    private Box box;

    public ReadThread(Box box) {
        this.box = box;
    }

    public void run() {
        int val;
        while ((val = box.read()) != Box.SENTINEL) {
            System.out.println(val);
        }
    }

}

