package Thread.Ushtrime.simplethread;

public class TestThreeThreads {
    public static void main(String[] args) {
        Thread ubt = new SimpleThread("UBT");
        ubt.setPriority(Thread.MAX_PRIORITY);

        Thread riinvest = new SimpleThread("RIINVEST");
        riinvest.setPriority(Thread.NORM_PRIORITY);

        Thread up = new SimpleThread("UP");
        up.setPriority(Thread.MIN_PRIORITY);

        up.start();
        riinvest.start();
        ubt.start();




    }
}
