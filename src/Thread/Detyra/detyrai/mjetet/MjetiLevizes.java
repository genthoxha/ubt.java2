package Thread.Detyra.detyrai.mjetet;

import Thread.Detyra.detyrai.kafshet.GaraException;

public abstract class MjetiLevizes {

    private String prodhuesi;
    private int vitiProdhimit;
    private double volumiMotorit;

    public MjetiLevizes(String prodhuesi, int vitiProdhimit, double volumiMotorit) throws GaraException {
        if (prodhuesi == null || prodhuesi.trim().equals("")) {
            throw new GaraException("Prodhuesi nuk mund te jete i zbrazet!");
        }
        if (vitiProdhimit < 2000) {
            throw new GaraException("Viti i prodhimit duhet te jete se paku 2000!");
        }
        if (volumiMotorit <= 0) {
            throw new GaraException("Volumi i motorit duhet te jete pozitiv!");
        }
        this.prodhuesi = prodhuesi;
        this.vitiProdhimit = vitiProdhimit;
        this.volumiMotorit = volumiMotorit;
    }

    public String getProdhuesi() {
        return prodhuesi;
    }

    public int getVitiProdhimit() {
        return vitiProdhimit;
    }

    public double getVolumiMotorit() {
        return volumiMotorit;
    }

    @Override
    public String toString() {
        return prodhuesi + " " + volumiMotorit + " cc - " + vitiProdhimit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MjetiLevizes) {
            MjetiLevizes ml = (MjetiLevizes) obj;
            return prodhuesi.equals(ml.getProdhuesi())
                    && vitiProdhimit == ml.getVitiProdhimit()
                    && volumiMotorit == ml.getVolumiMotorit();
        }
        return false;
    }

}

