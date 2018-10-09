package Thread.Detyra.detyrai;

public abstract class MjetiLeviz {
    private String prodhuesi;
    private int vitiProdhimit;
    private double volumiMotorit;

    public MjetiLeviz(String prodhuesi, int vitiProdhimit, double volumiMotorit) throws GaraException {
        if (Util.isEmpty(prodhuesi)) {
            throw new GaraException("Prodhuesi nuk duhet te jete i zbrazet");
        }
        if (vitiProdhimit < 2000) {
            throw new GaraException("Prodhimi i vitit duhet te jete mbi vitin 2000");
        }
        if (volumiMotorit < 1.2) {
            throw new GaraException("Mjeti duhet te jete mbi vleren 1.2");
        }
    }

    public String toString() {
        return prodhuesi + " " + volumiMotorit + " cc - " + vitiProdhimit;
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

    public boolean equals(Object obj) {
        if (obj instanceof MjetiLeviz) {
            MjetiLeviz mjetiLeviz = (MjetiLeviz) obj;
            return prodhuesi.equals(mjetiLeviz.prodhuesi)
                    && vitiProdhimit == mjetiLeviz.vitiProdhimit
                    && volumiMotorit == mjetiLeviz.volumiMotorit;
        }
        return false;
    }
}
