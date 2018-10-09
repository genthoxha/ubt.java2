package Thread.Detyra.detyrai.mjetet;

public class VeturaSigurise extends MjetiLevizes {
    private String ngjyra;


    public VeturaSigurise(String prodhuesi, int vitiProdhimit, double volumiMotorit, String ngjyra)throws GaraException {
        super(prodhuesi,vitiProdhimit,volumiMotorit);
        if (Util.isEmpty(ngjyra)) {
            throw new GaraException("Ngjyra nuk duhet te jete e zbrazet");
        }
    }


    public String toString() {
        return getClass().getSimpleName() + " " + super.toString() + ": " + ngjyra;
    }

    public String getNgjyra() {
        return ngjyra;
    }
}
