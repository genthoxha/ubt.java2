package Mixed.Libri;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Biblioteka {

    private String emri;
    private ArrayList<Libri> librat;

    public Biblioteka(String e) throws LibriException {
        if (e == null || e.trim().isEmpty()) {
            throw new LibriException("Emri i bibliotekes nuk mund te jete i zbrazet!");
        }
        emri = e;
        librat = new ArrayList<Libri>();
    }

    public void shtoLibrin(Libri l) throws LibriException {
        if (l == null) {
            throw new LibriException("Libri eshte i painicializuar!");
        }
        if (librat.contains(l)) {
            throw new LibriException("Libri ekziston ne biblioteke!");
        }
        librat.add(l);
    }

    public Enumeration<Libri> titulliEnumeration(String t) throws LibriException {
        if (t == null || t.trim().isEmpty()) {
            throw new LibriException("Titulli i librit nuk mund te filloj si i zbrazet!");
        }
        if (librat.isEmpty()) {
            throw new LibriException("Nuk ka asnje liber ne biblioteke!");
        }

        return new Enumeration<Libri>() {
            private int index = 0;

            public boolean hasMoreElements() {
                return index < librat.size();
            }

            public Libri nextElement() {
                if (index < librat.size()) {
                    Libri l = librat.get(index++);
                    if (l.getTitulli().startsWith(t)) {
                        return l;
                    }
                    if (hasMoreElements()) {
                        return nextElement();
                    }
                }
//                return null;
                throw new NoSuchElementException();
            }
        };
    }

    public Iterator<Libri> minVitiIterator(int v) throws LibriException {
        if (v <= 0) {
            throw new LibriException("Viti i publikimit te librit duhet te jete pozitiv!");
        }
        if (librat.isEmpty()) {
            throw new LibriException("Nuk ka asnje liber ne biblioteke!");
        }

        class MinVitiIterator implements Iterator<Libri> {
            private int index = 0;

            public boolean hasNext() {
                return index < librat.size();
            }
            public Libri next() {
                if (index < librat.size()) {
                    Libri l = librat.get(index++);
                    if (l.getVitiPublikimit() < v) {
                        return l;
                    }
                    if (hasNext()) {
                        return next();
                    }
                }
                return null;
//                throw new NoSuchElementException();
            }
        }
        return new MinVitiIterator();
    }

    public static void main(String[] args) {
        try {
            Biblioteka b = new Biblioteka("UBT Library");
            b.shtoLibrin(new Libri(12345, "Java 1", 2010));
            b.shtoLibrin(new Libri(22345, "Java 2", 2012));
            b.shtoLibrin(new Libri(32345, "Databaza", 2010));
            b.shtoLibrin(new Libri(42345, "Rrjeta", 2012));
            b.shtoLibrin(new Libri(52345, "BTI 1", 2011));
            b.shtoLibrin(new Libri(11345, "Anatomia 1", 2005));
            b.shtoLibrin(new Libri(21345, "Robotika 1", 2010));
            b.shtoLibrin(new Libri(22375, "Robotika 2", 2012));
            b.shtoLibrin(new Libri(31345, "Anatomia 2", 2012));
            System.out.println();
            System.out.println("Librat titulli i te cilave fillon me \"Ja\" me WHILE:");
            Enumeration<Libri> en = b.titulliEnumeration("Ja");
            try {
                while (en.hasMoreElements()) {
                    System.out.println(en.nextElement());
                }
            } catch (NoSuchElementException ex) {}
            System.out.println();
            System.out.println("Librat titulli i te cilave fillon me \"Ja\" me FOR:");
            try {
                for (en = b.titulliEnumeration("Ja"); en.hasMoreElements();) {
                    System.out.println(en.nextElement());
                }
            } catch (NoSuchElementException ex) {}

            System.out.println();
            System.out.println();
            System.out.println("Librat para vitit 2012 me WHILE:");
            Iterator<Libri> it = b.minVitiIterator(2012);
            while (it.hasNext()) {
                Libri l = it.next();
                if (l != null) {
                    System.out.println(l);
                }
            }
            System.out.println();
            System.out.println("Librat para vitit 2012 me FOR:");
            for (it = b.minVitiIterator(2012); it.hasNext();) {
                Libri l = it.next();
                if (l != null) {
                    System.out.println(l);
                }
            }
        } catch (LibriException le) {
            le.printStackTrace();
        }
    }
}







