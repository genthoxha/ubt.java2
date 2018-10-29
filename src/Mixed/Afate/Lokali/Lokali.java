package Mixed.Afate.Lokali;

import java.util.Objects;

public class Lokali {

    private String emri;
    private int kapaciteti;


    public Lokali(String emri, int kapaciteti) throws EventException {
        if (Util.isEmpty(emri)) {
            throw new EventException("Lokali: Emri nuk duhet te jete i zbrazet ose null!");
        }
        if (kapaciteti < 20) {
            throw new EventException("Lokali: Kapaciteti lokalit duhet te jete vlere me e madhe se 20!");
        }
        this.emri = emri;
        this.kapaciteti = kapaciteti;
    }


    public String getEmri() {
        return emri;
    }

    public int getKapaciteti() {
        return kapaciteti;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lokali) {
            Lokali l = (Lokali) obj;
            return emri.equals(l.getEmri()) && kapaciteti == l.getKapaciteti();
        }
        return false;
    }

    public int hashCode() {
        int hash = 2;
        hash = hash + Objects.hashCode(emri);
        hash = hash + Objects.hashCode(kapaciteti);
        return hash;
    }

}
