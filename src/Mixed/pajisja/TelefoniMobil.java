package Mixed.pajisja;

import java.util.Vector;

public class TelefoniMobil extends Pajisja implements Komunikimi {

    private boolean isSmart;
    private Vector<Komunikimi> listaKomunikimeve;

    public TelefoniMobil(String nrSerik, String modeli, boolean isSmart) throws PajisjaException {
        super(nrSerik, modeli);
        this.isSmart = isSmart;
        listaKomunikimeve = new Vector<>();
    }

    @Override
    public void filloKomunikimin() {
        System.out.println("Filloi komunikimi nga telefoni: " + (isSmart ? "i menqur" : "jo i menqur") + " me nrSerik: " + getNrSerik());
    }

    @Override
    public void dergoMesazh(String mesazhi, String adresa, boolean kaBashkengjitje) throws PajisjaException {
        if (isSmart)
            listaKomunikimeve.add(new Viber(mesazhi, adresa, kaBashkengjitje));
        System.out.println("Komunikimi permes Viber: " + mesazhi + " : " + adresa + (kaBashkengjitje ? "Ka bashkangjitje" : "Ska Bashkangjitje"));
    }
}
