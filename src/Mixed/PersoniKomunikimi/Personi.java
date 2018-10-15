package Mixed.PersoniKomunikimi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Personi {

    private final Lock lock = new ReentrantLock();
    private String emri;

    public Personi(String emri) {
        this.emri = emri;
    }

    public String getEmri() {
        return emri;
    }

    public Lock getLock() {
        return lock;
    }

    public boolean tentoKomunikimin(Personi personiTjeter) {
        boolean personi1Lock = false;
        boolean personi2Lock = false;

        personi1Lock = lock.tryLock();
        if (personi1Lock) {
            personi2Lock = personiTjeter.getLock().tryLock();
        }
        if (personi1Lock && !personi2Lock) {
            lock.unlock();
        }
        return personi1Lock && personi2Lock;
    }

    public void komuniko(Personi personiTjeter) {
        if (tentoKomunikimin(personiTjeter)) {
            try {
                System.out.printf("Jam %s duke komunikuar me %s.%n", emri, personiTjeter.getEmri());
            } finally {
                lock.unlock();
                personiTjeter.getLock().unlock();
            }
        }
        System.out.printf("==>Tentim komunikimi:%n"
                + "\tJam %s duke tentuar te komunikoj me %s.%n"
                + "\tSi duket %s eshte duke komunikuar me dike!%n", emri, personiTjeter.getEmri(), personiTjeter.getEmri());
    }
}

