package Mixed.PersoniKomunikimi;

import java.util.Random;

public class Komunikimi implements Runnable {

    private final Personi personiPare;
    private final Personi personiDyte;

    public Komunikimi(Personi personiPare, Personi personiDyte) {
        this.personiPare = personiPare;
        this.personiDyte = personiDyte;
    }

    public void run() {
        Random random = new Random();
        for (int counter = 0; counter < 10; counter++) {
            try {
                Thread.sleep(random.nextInt(500));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            personiPare.komuniko(personiDyte);
        }

    }

    public static void main(String[] args) {

        final Personi personi1 = new Personi("Personi 1");
        final Personi personi2 = new Personi("Personi 2");
        final Personi personi3 = new Personi("Personi 3");
        final Personi personi4 = new Personi("Personi 4");

        new Thread(new Komunikimi(personi1, personi2)).start();
        new Thread(new Komunikimi(personi2, personi1)).start();
        new Thread(new Komunikimi(personi1, personi3)).start();
        new Thread(new Komunikimi(personi3, personi1)).start();
        new Thread(new Komunikimi(personi1, personi4)).start();
        new Thread(new Komunikimi(personi4, personi1)).start();
        new Thread(new Komunikimi(personi2, personi3)).start();
        new Thread(new Komunikimi(personi3, personi2)).start();
        new Thread(new Komunikimi(personi2, personi4)).start();
        new Thread(new Komunikimi(personi4, personi2)).start();
        new Thread(new Komunikimi(personi3, personi4)).start();
        new Thread(new Komunikimi(personi4, personi3)).start();

    }


}
