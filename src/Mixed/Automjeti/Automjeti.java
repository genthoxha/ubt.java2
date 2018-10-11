package Mixed.Automjeti;

public class Automjeti {
    private int nrShasise;
    private String prodhuesi;
    private int vitiProdhimit;

    public Automjeti(int nrShasise, String prodhuesi, int vitiProdhimit) throws AutomjetiException {
        if (nrShasise <= 0) {
            throw new AutomjetiException("Nr shasise nuk duhet te jete negativ");
        }
        if (prodhuesi == null || prodhuesi.trim().equals("")) {
            throw new AutomjetiException("Prodhuesi nuk duhet te jete i zbrazet");
        }
        if (vitiProdhimit < 1950) {
            throw new AutomjetiException("Viti prodhimit nuk duhet te jete nen vitin 1950");
        }
    }

    public int getVitiProdhimit() {
        return vitiProdhimit;
    }

    public void setVitiProdhimit(int vitiProdhimit) throws AutomjetiException {
        if (vitiProdhimit < 1950) {
            throw new AutomjetiException("Viti prodhimit nuk duhet te jete nen vitin 1950");
        }
        this.vitiProdhimit = vitiProdhimit;
    }

    public String getProdhuesi() {

        return prodhuesi;
    }

    public void setProdhuesi(String prodhuesi) throws AutomjetiException {
        if (prodhuesi == null || prodhuesi.trim().equals("")) {
            throw new AutomjetiException("Prodhuesi nuk duhet te jete i zbrazet");
        }
        this.prodhuesi = prodhuesi;
    }

    public String toString() {
        return nrShasise + ": " + prodhuesi + " - " + vitiProdhimit;
    }

    public int getNrShasise() {
        return nrShasise;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Automjeti) {
            Automjeti a = (Automjeti) obj;
            return nrShasise == a.getNrShasise();
        }
        return false;
    }
}
