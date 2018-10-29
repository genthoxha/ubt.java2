package Mixed.Afate.Lokali;

public class Ushqimi extends Artikulli {

    private String emri;

    public Ushqimi(int cmimi, String emri) throws EventException {
        super(cmimi);
        if (Util.isEmpty(emri)) {
            throw new EventException("Ushqimi: Emri i ushqimit nuk duhet te jete i zbraze");
        }
    }

    public String getEmri() {
        return emri;
    }

    @Override
    public String toString() {
        return "Ushqimi: "+emri+super.toString();
    }
}
