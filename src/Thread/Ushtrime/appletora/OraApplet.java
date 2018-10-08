package Thread.Ushtrime.appletora;

import java.applet.Applet;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OraApplet extends Applet implements Runnable {

    private SimpleDateFormat sdf = null;
    private Thread oraThread = null;
    boolean condition = true;

    public void init() {
        System.out.println("NE INIT");
        sdf = new SimpleDateFormat("HH:mm:ss");
        oraThread = new Thread(this, "ORA");
    }

    public void start() {
        System.out.println("NE START");
        condition = true;
        oraThread.start();
    }

    public void paint(Graphics graphics) {
        Date date = new Date();
        graphics.drawString("ORA: " + sdf.format(date), 5, 10);
    }

    @Override
    public void run() {
        System.out.println("NE RUN " + oraThread.getId());
        while (condition) {
            repaint();
            try {
                oraThread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("Po e stopojme oren");
    }

    public void stop() {
        condition = false;
    }
}
