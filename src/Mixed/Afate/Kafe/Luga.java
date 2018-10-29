package Mixed.Afate.Kafe;

public class Luga extends Artikulli {

    private boolean eshteMetalik;


    public Luga(String modeli, double cmimi, Lloji.llojiKafes lloji,boolean eshteMetalik) throws ArtikulliException {
        super(modeli, cmimi, lloji);
        this.eshteMetalik = eshteMetalik;
    }

    public boolean getEshteMetalik() {
        return eshteMetalik;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Luga) {
            final Luga other = (Luga) object;
            return super.equals(other) && eshteMetalik ==  other.getEshteMetalik();
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", metalike? " + (eshteMetalik ? "PO" : "JO");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.eshteMetalik ? 1 : 0);
        return hash;
    }


}
