package Mixed.Afate.Kafe;

import java.util.Hashtable;

public class Kafe {

    private String emri;
    private Hashtable<Artikulli, Integer> artikujt;

    public Kafe(String emri) throws ArtikulliException {
        if (emri == null || emri.trim().equals("")) {
            throw new ArtikulliException("Emri nuk duhet te jete i zbrazte");
        }
        this.emri = emri;
        this.artikujt = new Hashtable<>();
    }

    public void shtoArtikull(Artikulli artikulli, int sasia) throws ArtikulliException {
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

    public boolean blejArtikullin(Artikulli artikulli) throws ArtikulliException {
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

    private boolean merrArtikullin(Artikulli artikulli) throws ArtikulliException {
        return blejArtikullin(artikulli);
    }

    public Seti ndertoSetin(String modeli, Lloji.llojiKafes lloji, int nr) throws ArtikulliException {
        Seti seti = new Seti(modeli, lloji);
        for (int i = 0; i < nr; i++) {
            Filxhani filxhani = new Filxhani(modeli, 100, lloji, 120);
            Tabaku tabaku = new Tabaku(modeli, 50, lloji, 7.5);
            Luga luga = new Luga(modeli, 25, lloji, true);
            Integer sasiaFilxhani = artikujt.get(filxhani);
            Integer sasiaTabaku = artikujt.get(tabaku);
            Integer sasiaLuga = artikujt.get(luga);

            if (sasiaFilxhani == null || sasiaFilxhani < nr
                    || sasiaTabaku == null || sasiaTabaku < nr
                    || sasiaLuga == null || sasiaLuga < nr) {
                throw new ArtikulliException("Nuk mund te ndertohet seti");
            }
            merrArtikullin(filxhani);
            merrArtikullin(tabaku);
            merrArtikullin(luga);

            Kombinimi kombinimi = new Kombinimi(filxhani, tabaku, luga);
            seti.shtoKombinimin(kombinimi);
            shtoArtikull(seti, 1);
        }
        return seti;
    }


}
