package Mixed.pajisja;

public class SMS implements Komunikimi{



    @Override
    public void dergoMesazh(String mesazhi, String adresa, boolean kaBashkengjitje) {
        System.out.println("Komunikimi permes SMS: " + mesazhi + " - " + adresa + " Ska bashkangjitje");
    }


}
