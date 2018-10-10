package Thread.Detyra.detyrai.mjetet;

import Thread.Detyra.detyrai.kafshet.GaraException;

import java.util.Random;

public class VeturaGaruese extends MjetiGarues {

    public VeturaGaruese(String p, int vP, double vM,int pS, int gjP) throws GaraException {
        super(p, vP, vM, pS, gjP);
        if (vM < 2.0) {
            throw new GaraException("Vetura nuk duhet te jete me e vogel se 2.0 kubik");
        }
    }

    public String getLloji() {
        return "Vetura";
    }

    public void run() {
        Random randomNumber = new Random();
        while (getDistanca() < getGjatesiaPistes()) {
            try {
                Thread.sleep(randomNumber.nextInt(750));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                garo();
            } catch (GaraException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void garo() throws GaraException {
        setDistanca((getDistanca() + 150 > getGjatesiaPistes() ? getGjatesiaPistes() : getDistanca() + 150));
        System.out.println(this);
    }
}
