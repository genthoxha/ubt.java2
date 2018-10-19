package Mixed.pajisja;

public class Viber implements Komunikimi {
    private String mesazhi;
    private String adresa;
    private boolean kaBashkangjitje;

    public Viber(String mesazhi, String adresa, boolean kaBashkengjitje) throws PajisjaException {
        if (mesazhi == null || mesazhi.trim().isEmpty()) {
            throw new PajisjaException("Mesazhi null");
        }
        if (adresa == null || adresa.trim().isEmpty()) {
            throw new PajisjaException("Adresa eshte null");
        }
        this.mesazhi = mesazhi;
        this.adresa = adresa;
        this.kaBashkangjitje = kaBashkengjitje;
    }

    @Override
    public void dergoMesazh(String mesazhi, String adresa, boolean kaBashkengjitje) throws PajisjaException {
        System.out.println("Komunikimi permes Viber: " + mesazhi + " : " + adresa + (kaBashkengjitje ? " Ka bashkangjitje " : " Nuk ka bashkangjitje"));
    }
}
