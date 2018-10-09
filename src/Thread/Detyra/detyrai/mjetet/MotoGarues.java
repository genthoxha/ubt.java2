package Thread.Detyra.detyrai.mjetet;

import Thread.Detyra.detyrai.kafshet.GaraException;

import java.util.Random;

public class MotoGarues extends MjetiGarues implements Garon, Runnable {

    public String getLloji() {
        return "Moto";
    }

    public MotoGarues(String prodhuesi, int vitiProdhimit, double volumiMotorit, int pozitaStartuese, int gjatesiaPistes)
            throws GaraException {
        super(prodhuesi, vitiProdhimit, volumiMotorit, pozitaStartuese, gjatesiaPistes);
        if (volumiMotorit < 1.2 || volumiMotorit > 2.5) {
            throw new GaraException("Volumi motorit duhet te jete brenda 1.2 ~ 2.5 kubik");
        }
    }

    public void run() {

        Random random = new Random();
        if (getDistanca() < getGjatesiaPistes()) {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    public void garo() throws GaraException {
        setDistanca(100 + getDistanca() > getGjatesiaPistes() ? getGjatesiaPistes() : getDistanca() + 100);
        System.out.println(this);
    }

}
