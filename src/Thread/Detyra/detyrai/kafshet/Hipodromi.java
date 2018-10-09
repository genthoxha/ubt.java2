package Thread.Detyra.detyrai.kafshet;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Hipodromi {

    private String emri;
    private Vector<KafshaGaruese> kafshetGaruese;

    public Hipodromi(String emri) throws GaraException {
        if (emri == null || emri.trim().isEmpty()) {
            throw new GaraException("Emri hipodromit nuk duhet te jete null");
        }
        this.emri = emri;
        kafshetGaruese = new Vector<>();
    }

    public void shtoKafshen(KafshaGaruese k)throws GaraException {
        if (k == null) {
            throw new GaraException("Kafsha eshtee pa inicializuar");
        }
        if (kafshetGaruese.contains(k)) {
            throw new GaraException("Kafsha egziston");
        }
        kafshetGaruese.add(k);
    }

    public void shtypKafshet() {
        for (KafshaGaruese kg : kafshetGaruese) {
            System.out.println(kg);
        }
    }
    public void shtypKafshetIterator() {
        Iterator<KafshaGaruese> iterator = kafshetGaruese.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    public void filloGaren() {
        Enumeration<KafshaGaruese> enumeration = kafshetGaruese.elements();
        while (enumeration.hasMoreElements()) {
            KafshaGaruese kafshaGaruese = enumeration.nextElement();
            if (kafshaGaruese instanceof KaliGarues) {
                kafshaGaruese.setPriority(Thread.MAX_PRIORITY);
            }
            kafshaGaruese.start();
        }
    }
    public static void main(String[] args) {
        int pozita = 1;
        try {
            Hipodromi h = new Hipodromi("Te Besarti");
            h.shtoKafshen(new QeniGarues(1, "Murki", pozita++));
            h.shtoKafshen(new QeniGarues(2, "Sharki", pozita++));
            h.shtoKafshen(new KaliGarues(2, "Silver", pozita++));
            h.shtoKafshen(new KaliGarues(3, "Nitro", pozita++));
            System.out.println("Te gjitha kafshet: ");
            h.shtypKafshet();
            System.out.println();
            h.filloGaren();
        } catch (GaraException ge) {
            ge.printStackTrace();
        }
    }

}
