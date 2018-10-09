package Thread.Detyra.detyrai.mjetet;

import Thread.Detyra.detyrai.kafshet.GaraException;

import java.util.Enumeration;
import java.util.Vector;

public class Gara {

    private final int GJATESIA_E_PISTES;
    private Vector<MjetiLevizes> mjetet;

    public Gara(int GJ_P) throws GaraException {
        if (GJ_P <= 0) {
            throw new GaraException("Gjatesia e pistes duhet te jete pozitive!");
        }
        this.GJATESIA_E_PISTES = GJ_P;
        mjetet = new Vector<MjetiLevizes>();
    }

    public int getGJATESIA_E_PISTES() {
        return GJATESIA_E_PISTES;
    }

    public void shtoMjetin(MjetiLevizes ml) throws GaraException {
        if (ml == null) {
            throw new GaraException("Instanca e painicializuar!");
        }
        if (mjetet.contains(ml)) {
            throw new GaraException("Mjeti ekziston!");
        }
        mjetet.add(ml);
    }


    public void shtypMjetet(){
        for (MjetiLevizes ml : mjetet) {
            System.out.println(ml);
        }
    }

    public void filloGaren(String lloji) throws GaraException {
        if (lloji == null || (!lloji.equals("Vetura") && !lloji.equals("Moto") && !lloji.equals("Universal"))) {
            throw new GaraException("Lloji i gares duhet te jete: Vetura , Moto ose Universal!");
        }
        if (mjetet.isEmpty()) {
            throw new GaraException("Nuk ka asnje mjet garues!");
        }
        Enumeration<MjetiLevizes> en = mjetet.elements();
        while (en.hasMoreElements()) {
            MjetiLevizes ml = en.nextElement();
            if (ml instanceof MjetiGarues) {
                if (lloji.equals("Universal") || lloji.equals(((MjetiGarues) ml).getLloji())) {
                    Thread th = new Thread((Runnable) ml);
                    th.start();
                }
            }
        }
    }

    public static void main(String[] args) {
        int pozita = 1;
        try {
            Gara g = new Gara(2500);
            g.shtoMjetin(new VeturaGaruese("Opel", 2005, 2.5, pozita++, g.getGJATESIA_E_PISTES()));
            g.shtoMjetin(new VeturaGaruese("BMW", 2008, 3.0, pozita++, g.getGJATESIA_E_PISTES()));
            g.shtoMjetin(new VeturaGaruese("Mercedes-Benz", 2010, 3.5, pozita++, g.getGJATESIA_E_PISTES()));
            g.shtoMjetin(new MotoGarues("BMW", 2010, 2.2, pozita++, g.getGJATESIA_E_PISTES()));
            g.shtoMjetin(new MotoGarues("Kawasaki", 2008, 2.5, pozita++, g.getGJATESIA_E_PISTES()));
            g.shtoMjetin(new MotoGarues("Suzuki", 2012, 1.9, pozita++, g.getGJATESIA_E_PISTES()));
            g.shtoMjetin(new VeturaSigurise("VW", 2008, 1.6, "Zeze"));
            System.out.println("Te gjitha mjetet levizese: ");
            g.shtypMjetet();
            System.out.println();
            g.filloGaren("Vetura");
        } catch (GaraException ge) {
            ge.printStackTrace();
        }
    }
}

