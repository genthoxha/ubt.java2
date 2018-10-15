package Mixed.fakulteti;

public class Asistenti extends Mesimdhenesi implements Angazhoet {

    public Asistenti(Fakulteti f, String nP, String e, String mb,char gj) throws PersoniException {
        super(f,nP,e,mb,gj);

    }

    public String kaRolin() {
        return "Asistent";
    }

    public String ktheAngazhimin() {
        return "Ushtrime Praktike";
    }

}
