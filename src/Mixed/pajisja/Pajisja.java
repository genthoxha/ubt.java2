package Mixed.pajisja;

public abstract class Pajisja {

    private String nrSerik;
    private String modeli;

    public Pajisja(String nrSerik, String modeli) throws PajisjaException {
        if (nrSerik == null || nrSerik.trim().isEmpty()) {
            throw new PajisjaException("Nr. Serik nuk duhet te jete i zbrazet ose null !");
        }
        if (modeli == null || modeli.trim().isEmpty()) {
            throw new PajisjaException("Modeli nuk duhet te jete i zbrazet ose null !");
        }
        this.nrSerik = nrSerik;
        this.modeli = modeli;
    }

    public abstract void filloKomunikimin();

    public String getNrSerik() {
        return nrSerik;
    }

    public String getModeli() {
        return modeli;
    }

    public void setModeli(String modeli) {
        this.modeli = modeli;
    }

    public String toString() {
        return nrSerik + " " + modeli;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pajisja) {
            Pajisja p = (Pajisja) obj;
            return nrSerik == p.getNrSerik() && modeli == p.getModeli();
        }
        return false;
    }
}
