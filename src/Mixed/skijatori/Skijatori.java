package Mixed.skijatori;

import java.util.ArrayList;
import java.util.List;

public class Skijatori implements Comparable<Skijatori> {
    private String emri;
    private String shteti;
    private int kodi;
    // Skijatoret mund te marrin pjese ne nje apo me shume disiplina
    private List<Disciplina.Alpin> disciplinat;

    public Skijatori(String e, String sh, int k) throws FISEException {
        if (Util.isEmpty(e)) {
            throw new FISEException("Emri skijatorit nuk duhet te jete i zbrazet!");
        }
        if (Util.isEmpty(sh) || sh.length() != 3) {
            throw new FISEException("Shteti nuk duhet i zbrazet dhe duhet pembaje vetem 3 shkronja!");
        }
        if (k <= 0) {
            throw new FISEException("Kodi duhet te jete numer pozitiv dhe jo zero!");
        }
        this.emri = e;
        this.shteti = sh;
        this.kodi = k;
        disciplinat = new ArrayList<>();
    }

    public String getEmri() {
        return emri;
    }

    public void shtoDisciplinen(Disciplina.Alpin disc) throws FISEException {
        if (disc == null) {
            throw new FISEException("Disciplina e dhene eshte NULL");
        }
        if (disciplinat.contains(disc)) {
            throw new FISEException("Disciplina e dhene egziston");
        }
        disciplinat.add(disc);
    }

    public boolean iTakonDisciplines(Disciplina.Alpin disc) throws FISEException {
        if (disciplinat.contains(disc) && disc != null) {
            throw new FISEException("Disciplina egziston");
        }
        return false;
    }

    public String toString() {
        return "(" + kodi + ") " + emri + ": " + shteti;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Skijatori) {
            final Skijatori skijatori = (Skijatori)obj;
            return kodi == skijatori.kodi;
        }
        return false;
    }

    public int compareTo(Skijatori o) {
        return kodi - o.kodi;
    }



}
