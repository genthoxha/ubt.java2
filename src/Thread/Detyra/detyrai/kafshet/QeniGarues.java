package Thread.Detyra.detyrai.kafshet;

import java.util.Random;

public class QeniGarues extends KafshaGaruese implements Garon{

    private int distanca = 0;

    public QeniGarues(int m,String e,int pS)throws GaraException {
        super(m,e,pS);
        if (m < 1 || m > 10) {
            throw new GaraException("Mosha duhet te jete 1 deri 10");
        }
        if (pS <= 0) {
            throw new GaraException("Pozita startuese duhet te jete me shume se zero");
        }
    }

    public void Vrapo() {
        distanca = distanca + 10;
        System.out.println(toString());
    }

    public void run() {
        Random random = new Random();
        while (distanca < GJATESIA_PISTES) {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Vrapo();
        }
    }

    public String toString() {
        return "( " + getClass().getSimpleName() + " ) " + getEmri() + " vrapoi " + distanca + " metra.";
    }

}
