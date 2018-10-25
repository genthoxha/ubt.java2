package Mixed.Afate.Kafe;

import java.util.Objects;

public abstract class Artikulli {

    private String modeli;
    private double cmimi;
    private Lloji.llojiKafes llojiKafes;
    public Artikulli(String modeli, double cmimi,Lloji.llojiKafes lloji) throws ArtikulliException {
        if (modeli == null || modeli.trim().equals("")) {
            throw new ArtikulliException("Modeli nuk duhet te jete null");
        }
        this.modeli = modeli;
        if (cmimi <= 0) {
            throw new ArtikulliException("Cmimi nuk duhet te jete negativ");
        }
        this.cmimi = cmimi;
        if (lloji == null) {
            throw new ArtikulliException("Lloji i artikullit eshte NULL");
        }
        this.llojiKafes = lloji;
    }

    public String getModeli() {
        return modeli;
    }
    public Lloji.llojiKafes getLloji() {
        return llojiKafes;
    }

    public void setModeli(String modeli) {
        this.modeli = modeli;
    }

    public double getCmimi() {
        return cmimi;
    }

    public void setCmimi(int cmimi) {
        this.cmimi = cmimi;
    }

    public String toString() {
        return getClass()+" i/e llojit: "+llojiKafes+" e modelit" + modeli + ": " + getCmimi();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object instanceof Artikulli) {
            Artikulli a = (Artikulli) object;
            return this.modeli.equals(a.getModeli()) && this.cmimi == a.getCmimi();
        }
        return false;
    }

    @Override
    public int hashCode() {
       int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.modeli);
        hash = 97 * hash + Objects.hashCode(this.llojiKafes);
        return hash;
    }
    
}
