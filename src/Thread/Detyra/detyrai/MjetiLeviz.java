package Thread.Detyra.detyrai;

public class MjetiLeviz {
    private String prodhuesi;
    private int vitiProdhimit;
    private double volumiMotorit;

    public MjetiLeviz(String prodhuesi, int vitiProdhimit, double volumiMotorit) throws GaraException {
        if (Util.isEmpty(prodhuesi)) {
            throw new GaraException("Prodhuesi nuk duhet te jete i zbrazet");
        }
    }
}
