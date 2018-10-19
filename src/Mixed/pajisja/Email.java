package Mixed.pajisja;

public class Email implements Komunikimi {

    private String mesazhi;
    private String adressa;
    private boolean kaBashkangjitje;

    public Email(String mesazhi, String adresa, boolean kaBashkangjitje) throws PajisjaException {


        if (mesazhi == null || mesazhi.trim().isEmpty()) {
            throw new PajisjaException("Mesazhi nuk duhet te jete null");
        }
        if (adresa == null || adresa.trim().isEmpty()) {
            throw new PajisjaException("Adresa nuk duhet te jete null");
        }
        this.mesazhi = mesazhi;
        this.adressa = adresa;
        this.kaBashkangjitje = kaBashkangjitje;

    }

    public void dergoMesazh(String mesazhi, String adresa, boolean kaBashkengjitje) {
        System.out.println("Komunikimi permes E-mail " + mesazhi + " : " + adresa + (kaBashkengjitje ? " Ka bashkangjitje" : " Ska bashkangjitje"));
    }

}
