package Mixed.Libri;

import java.security.Key;
import java.util.Hashtable;

public class Libraria {

    private String emri;
    private Hashtable<Integer,Libri> hashtableLibrat;

    public Libraria(String emri) throws LibriException {
        if (Util.isEmpty(emri)) {
            throw new LibriException("Emri i librit nuk duhet te jete null.");
        }
        this.emri = emri;
        hashtableLibrat = new Hashtable<>();
    }

    public boolean ekziston(int isbn)throws LibriException {
        if (isbn <= 0) {
            throw new LibriException("ISBN i librit duhet te jete pozitiv!");
        }
        return hashtableLibrat.containsKey(isbn);
    }

    public void shtoLibrin(Libri libri) throws LibriException {
        if (libri == null) {
            throw new LibriException("Libri nuk duhet te jete null");
        }
//        if (ekziston(libri.getIsbn())) { }
//        if (hashtableLibrat.contains(libri)) { } Vetem me hash table
        if (hashtableLibrat.containsKey(libri.getIsbn())) {
            throw new LibriException("Libri ekziston");
        }
        hashtableLibrat.put(libri.getIsbn(), libri);
    }

    public boolean fshijeLibrin(int isbn) throws LibriException {
        if (isbn <= 0) {
            throw new LibriException("Isbn i librit  duhet te jete pozitiv!");
        }
        return hashtableLibrat.remove(isbn) != null; // Vetem me HashTable
    }

    public static void main(String[] args) {
        try {
            Libraria l = new Libraria("Libraria ABC");
            l.shtoLibrin(new Libri(12345, "Java 1", 2010));
            l.shtoLibrin(new Libri(22345, "Java 2", 2012));
            l.shtoLibrin(new Libri(32345, "Databaza", 2010));
            l.shtoLibrin(new Libri(42345, "Rrjeta", 2012));
            l.shtoLibrin(new Libri(52345, "BTI 1", 2011));
            l.shtoLibrin(new Libri(11345, "Anatomia 1", 2005));
            l.shtoLibrin(new Libri(21345, "Robotika 1", 2010));
            l.shtoLibrin(new Libri(22375, "Robotika 2", 2012));
            l.shtoLibrin(new Libri(31345, "Anatomia 2", 2012));

            System.out.println();
            if (l.ekziston(11345)) {
                System.out.println("Test: Libri me isbn 11345 ekziston.");
            } else {
                System.out.println("Test: Libri me isbn 11345 nuk ekziston.");
            }
            System.out.println();
            if (l.fshijeLibrin(11345)) {
                System.out.println("Test: Libri me isbn 11345 eshte fshire.");
            } else {
                System.out.println("Test: Libri me isbn 11345 nuk eshte fshire.");
            }
            System.out.println();
            if (l.ekziston(11345)) {
                System.out.println("Test: Libri me isbn 11345 ekziston.");
            } else {
                System.out.println("Test: Libri me isbn 11345 nuk ekziston.");
            }
            
        } catch (LibriException e) {
            e.printStackTrace();
        }
    }


}
