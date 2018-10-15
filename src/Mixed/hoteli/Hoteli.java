package Mixed.hoteli;

public class Hoteli {
    private String emri;
    private int kategoria;
    private boolean depo;

    public Hoteli(String emri, int kategoria, boolean depo) throws SkiException {
        if (emri == null || emri.trim().equals("")) {
            throw new SkiException("Emri nuk duhet te jete i zbrazet");
        }
        if (kategoria < 1 || kategoria > 5) {
            throw new SkiException("Vlera e kategorise duhet te jete ndermjet vlerave 1 dhe 5");
        }
        this.emri = emri;
        this.kategoria = kategoria;
        this.depo = depo;
    }

    public String getEmri() {
        return emri;
    }

    public int getKategoria() {
        return kategoria;
    }

    public boolean isDepo() {
        return depo;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setKategoria(int kategoria) {
        this.kategoria = kategoria;
    }

    public void setDepo(boolean depo) {
        this.depo = depo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hoteli) {
            Hoteli h = (Hoteli) obj;
            return emri.equals(h.getEmri());
        }
        return false;
    }
}
