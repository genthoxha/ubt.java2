package Mixed.fakulteti;

public abstract class Personi {

    private String numriPersonal;
    private String emri;
    private String mbiemri;
    private char gjinia;

    public Personi(String nP, String e, String mb, char gj) throws PersoniException {
        if (Util.isEmpty(nP)) {
            throw new PersoniException("Numri personal nuk duhet te jete i zbrazet");
        }
        if (Util.isEmpty(e)) {
            throw new PersoniException("Emri nuk duhet te jete i zbrazet");
        }
        if (Util.isEmpty(mb)) {
            throw new PersoniException("Mbiemri nuk duhet te jete i zbrazet");
        }
        if (gj != 'M' && gj != 'F') {
            throw new PersoniException("Gjinia duhet te jete mashkull ose femer");
        }
        this.numriPersonal = nP;
        this.emri = e;
        this.mbiemri = mb;
        this.gjinia = gj;
    }

    public String getNumriPersonal() {
        return numriPersonal;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public char getGjinia() {
        return gjinia;
    }

    abstract String kaRolin();

    @Override
    public String toString() {
        return emri + " " + mbiemri + " " + gjinia + " " + numriPersonal;
    }
}
