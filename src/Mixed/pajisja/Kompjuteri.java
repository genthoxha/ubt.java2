package Mixed.pajisja;

import java.util.Vector;

public class Kompjuteri extends Pajisja implements Komunikimi {

    private Vector<Email> listK;

    public Kompjuteri(String mesazhi, String adresa) throws PajisjaException {
        super(mesazhi, adresa);
        listK = new Vector<>();
    }

    @Override
    public void filloKomunikimin() {
        System.out.println("Filloj komunikimi nga kompjuteri me nrSerik: " + getNrSerik());
    }
    @Override
    public void dergoMesazh(String mesazhi, String adresa, boolean kaBashkengjitje) throws PajisjaException {
        listK.add(new Email(mesazhi, adresa, kaBashkengjitje));
    }
}
