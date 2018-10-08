package Thread.Ushtrime.mythread;

public class ThreadIm extends Thread {

    private boolean ok = false;

    public ThreadIm(String emri) {
        super(emri);
        ok = true;
    }

    public void run() {
        int count = 0;
        while (ok) {
            System.out.println(getName() + ":" + (++count));
            try {
                sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println(getName() + ": perfundoi");
    }

    public void nok() {
        ok = false;
    }

}

