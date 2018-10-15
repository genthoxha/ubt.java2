package Mixed.fakulteti;

public class Profesori extends Mesimdhenesi implements Angazhoet {

    public Profesori(Fakulteti f,String nP, String e, String mb, char gj) throws PersoniException {
        super(f,nP, e, mb, gj);

    }

    public String kaRolin() {
        return "Profesor";
    }

    public String ktheAngazhimin() {
        return "Ligjerate";
    }

}
