package Mixed.Afate.Kafe;

public class Filxhani extends Artikulli {
    private int volumi;
    public Filxhani(String modeli, double cmimi, Lloji.llojiKafes lloji, int volumi) throws ArtikulliException{
        super(modeli, cmimi, lloji);
        if(volumi < 1 || volumi > 250) {
            throw new ArtikulliException("Volumi duhet te jete ne rangun 1 .. 250 ["+volumi+"]");
        }
        this.volumi = volumi;
    }

    public int getVolumi() {
        return volumi;
    }

    @Override
    public String toString() {
        return super.toString()+", volumi=" + volumi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.volumi;
        return hash + super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Filxhani) {
            final Filxhani other = (Filxhani)obj;
            return super.equals(obj) && volumi == other.volumi;
        }
        return false;
    }

}

