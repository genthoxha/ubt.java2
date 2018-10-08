package Thread.Ushtrime.simplethread;

public class SimpleThread extends Thread {

    public SimpleThread(String name) {
        super(name);
    }

    public static int ubt,riinivest,up = 0;

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (getName().equals("UBT")) {
                ubt++;
            } else if (getName().equals("RIINVEST")) {
                riinivest++;
            } else {
                up++;
            }
            System.out.println(i + ": " + getName());
            try {
                Thread.sleep((int) (Math.random() * 350));
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("FINISH: "+getName());
    }
}

