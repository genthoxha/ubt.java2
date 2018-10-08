package Thread.Ushtrime.appletthread;

import java.applet.Applet;

public class AppletThreadIm extends Applet implements Runnable {

    private Thread th = null;
    private boolean ok = false;

    public void init() {
        th = new Thread(this, "APP_THREAD_IM");
    }

    public void start() {
        ok = true;
        th.start();
    }

    public void run() {
        int count = 0;
        while (ok) {
            System.out.println(th.getName() + ": " + (++count));
            try {
                th.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println(th.getName() + ": FINISH");
    }

    public void stop() {
        ok = false;
    }

}
