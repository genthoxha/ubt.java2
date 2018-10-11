package Mixed.Automjeti;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class Autosalloni {

    private String emri;
    private List<Automjeti> automjetet;

    public Autosalloni(String emri) throws AutomjetiException {
        if (emri == null || emri.trim().equals("")) {
            throw new AutomjetiException("Emri autosallonit nuk duhet te jete null");
        }
        this.emri = emri;
        automjetet = new ArrayList<Automjeti>();

    }

    public void shtoAutomjetin(Automjeti a) throws AutomjetiException {
        if (a == null) {
            throw new AutomjetiException("Automjeti eshte null ");
        }
        if (automjetet.contains(a)) {
            throw new AutomjetiException("Automjeti egziston");
        }
        automjetet.add(a);
    }

    public Enumeration<Automjeti> prodhuesiEnumeration(String p) throws AutomjetiException {
        if (p == null || p.trim().equals("")) {
            throw new AutomjetiException("Parametri i dhene eshte null");
        }
        if (automjetet.isEmpty()) {
            throw new AutomjetiException("Nuk ka asnje automjet");
        }
        return new Enumeration<Automjeti>() {
            int index = 0;

            @Override
            public boolean hasMoreElements() {
                return index < automjetet.size();
            }

            @Override
            public Automjeti nextElement() {
                if (index < automjetet.size()) {
                    Automjeti a = automjetet.get(index++);
                    if (a.getProdhuesi().startsWith(p)) {
                        return a;
                    }
                    if (index < automjetet.size()) {
                        return nextElement();
                    }
                }
                return null;
            }

        };
    }

    public Iterator<Automjeti> minVitiIterator(int v) throws AutomjetiException {

        if (v <= 0) {
            throw new AutomjetiException("Vlera e vitit eshte e zbrazet");
        }
        if (automjetet.isEmpty()) {
            throw new AutomjetiException("Nuk ka asnje automjet te regjistruar ne autosallon");
        }

        class MinVitiIterator implements Iterator<Automjeti> {

            int index = 0;

            public boolean hasNext() {
                return index < automjetet.size();
            }

            public Automjeti next() {

                if (index < automjetet.size()) {
                    Automjeti a = automjetet.get(index++);
                    if (a.getVitiProdhimit() < v) {
                        return a;
                    }
                }

                if (hasNext()) {
                    return next();
                }
                return null;
            }
        }
        return new MinVitiIterator();
    }

    public static void main(String[] args) {
        try {
            Autosalloni a = new Autosalloni("Alberti");
            a.shtoAutomjetin(new Automjeti(123, "Audi a3", 2012));
            a.shtoAutomjetin(new Automjeti(122, "BMW", 2010));

            a.minVitiIterator(2012);
            a.prodhuesiEnumeration("B");

            System.out.println("Enumeration per min viti iterator me FOR: ");
        } catch (AutomjetiException e) {
        }
    }

}
