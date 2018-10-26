package Mixed.Afate.Kafe;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Kafe {

    private String emri;
    private Hashtable<Artikulli,Integer> artikujt;

    public Kafe(String emri) throws ArtikulliException {
        if (emri == null || emri.trim().equals("")) {
            throw new ArtikulliException("Emri nuk duhet te jete i zbrazte");
        }
        this.emri = emri;
        this.artikujt = new Hashtable<>();
    }

    public void shtoArtikull(Artikulli artikulli,int sasia) throws ArtikulliException {
        if (artikulli == null) {
            throw new ArtikulliException("shtoArtikullin: Artikulli nuk duhet te jete i zbrazet");
        }
        if (sasia <= 0) {
            throw new ArtikulliException("shtoArtikullin: Sasia jo pozitive ");
        }
        Integer sasiaEkzistuese = artikujt.get(artikulli);
        if (sasiaEkzistuese != null) {
            sasia = sasia + sasiaEkzistuese;
        }
        artikujt.put(artikulli, sasia);
    }
    public boolean blejArtikullin(Artikulli artikulli)throws ArtikulliException {
        if (artikulli == null) {
            throw new ArtikulliException("blejArtikullin: artikulli eshte NULL");
        }
        Integer sasiaEkzistuese = artikujt.get(artikulli);
        if (sasiaEkzistuese == null || sasiaEkzistuese == 0) {
            return false;
        }
        artikujt.put(artikulli, sasiaEkzistuese - 1);
        return true;
    }
    private boolean merrArtikullin(Artikulli artikulli)throws ArtikulliException{
        return blejArtikullin(artikulli);
    }
    

}
