package Mixed.fakulteti;

import java.util.ArrayList;

public class OraEMesimit {
    private Mesimdhenesi mesimdhenesi;
    private ArrayList<Studenti> studentet;
    private String lenda;
    private String lloji;

    public OraEMesimit(Mesimdhenesi mesimdhenesi, String lenda) throws FakultetiException {
        if(mesimdhenesi == null) {
            throw new FakultetiException("Mesimdhenesi i pa inicializuar");
        }

        if(lenda == null || lenda.trim().isEmpty()) {
            throw new FakultetiException("Lenda e zbrazet");
        }
        this.mesimdhenesi = mesimdhenesi;
        this.lenda = lenda;
        studentet = new ArrayList<>();
        lloji = mesimdhenesi.ktheAngazhimin();
    }

    public void shtoStudentin(Studenti s) throws FakultetiException {
        if(s == null) {
            throw new FakultetiException("Studenti i pa inicializuar");
        }

        if(studentet.contains(s)) {
            throw new FakultetiException("Studenti ekziston");
        }

        studentet.add(s);
    }

    public Mesimdhenesi getMesimdhenesi() {
        return mesimdhenesi;
    }

    public String getLenda() {
        return lenda;
    }

    public String getLloji() {
        return lloji;
    }

    public int numriIStudenteve() {
        return studentet.size();
    }

    public boolean equals(Object obj) {
        if(obj instanceof OraEMesimit) {
            OraEMesimit o = (OraEMesimit)obj;
            return lenda.equals(o.getLenda()) && lloji.equals(o.getLloji());
        }

        return false;
    }

    public String toString() {
        return mesimdhenesi.getEmri() + " " + mesimdhenesi.getMbiemri() + " - " +
                lenda + " : " + lloji;
    }

}
