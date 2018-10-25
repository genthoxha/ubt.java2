package Mixed.Afate.Kafe;

public class Tabaku extends Artikulli {

    private double madhesia;

    public Tabaku(String m, int c, Lloji.llojiKafes ll, double madhesia) throws ArtikulliException {
        super(m, c, ll);
        if (madhesia < 5 || madhesia > 12.5) {
            throw new ArtikulliException("Vlera e madhesis se tabakut duhete jete ndermjet 5 dhe 12.5!");
        }
        this.madhesia = madhesia;

    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Tabaku) {
            Tabaku other = (Tabaku) object;
            return super.equals(other)  && madhesia == other.getMadhesia();
        }
        return false;
    }

    private double getMadhesia() {
        return this.madhesia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.madhesia) ^ (Double.doubleToLongBits(this.madhesia) >>> 32));
        return hash;
    }
}
