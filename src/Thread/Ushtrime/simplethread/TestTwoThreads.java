package Thread.Ushtrime.simplethread;

public class TestTwoThreads {

    public static void main(String[] args) {
        new SimpleThread("UBT").run();
        new SimpleThread("UP").run();

    }

}
