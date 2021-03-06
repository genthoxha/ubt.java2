package Thread.Detyra.detyrai.mjetet;


import Thread.Detyra.detyrai.kafshet.GaraException;

public abstract class MjetiGarues extends MjetiLevizes implements Garon, Runnable {

    private final int gjatesiaPistes;
    private int pozitaStartuese;
    private int distanca;

    public MjetiGarues(String prodhuesi, int vitiProdhimit, double volumiMotorit, int pozitaStartuese, int gjatesiaPistes) throws GaraException {
        super(prodhuesi, vitiProdhimit, volumiMotorit);
        if (pozitaStartuese <= 0) {
            throw new GaraException("Pozita startuese nuk duhet te jete zero");
        }
        if (gjatesiaPistes <= 0) {
            throw new GaraException("Gjatesia e pistes nuk duhet te jete zero");
        }
        this.distanca = 0;
        this.pozitaStartuese = pozitaStartuese;
        this.gjatesiaPistes = gjatesiaPistes;
    }

    public int getPozitaStartuese() {
        return pozitaStartuese;
    }

    public int getDistanca() {
        return distanca;
    }

    public void setDistanca(int d) throws GaraException {
        if (d <= distanca) {
            throw new GaraException("Distanca nuk duhet te rritet!");
        }
        distanca = d;
    }

    public int getGjatesiaPistes() {
        return gjatesiaPistes;
    }

    public abstract void garo() throws GaraException, GaraException;

    public String toString() {
        return pozitaStartuese + " : " + "(" + getClass().getSimpleName() + " ) " + super.toString() + " pershkoi " + distanca + " metra";
    }


}
