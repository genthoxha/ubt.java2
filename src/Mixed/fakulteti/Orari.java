package Mixed.fakulteti;

import java.util.ArrayList;

public class Orari {

    private ArrayList<OraEMesimit> oretEMesimit;

    public Orari() {
        oretEMesimit = new ArrayList<>();
    }

    public void shtoOret(OraEMesimit oraEMesimit) throws FakultetiException {
        if (oraEMesimit == null) {
            throw new FakultetiException("Nuk lejohet qe ora e mesimit te jete null");
        }
        if (oraEMesimit.numriIStudenteve() < 3 || oraEMesimit.numriIStudenteve() > 30) {
            throw new FakultetiException("Ora e mesimit duhet te mbaje 3 deri ne 30 studente");
        }
        if (oretEMesimit.contains(oraEMesimit)) {
            throw new FakultetiException("Ora e mesimit egziston");
        }
        oretEMesimit.add(oraEMesimit);
    }

    public void shfletoMesimdhenesit(String lloji) throws FakultetiException {
        if (Util.isEmpty(lloji)) {
            throw new FakultetiException("Lloji nuk duhet te jete null");
        }
        if (lloji == null || !(lloji.equals("Ushtrime Praktike") || lloji.equals("Ligjerata"))) {
            throw new FakultetiException("Lloji jo valid");
        }
        class PrintMesimDhenesit {
            public void print() {
                for (OraEMesimit o : oretEMesimit) {
                    if (o.getLloji().equals(lloji)) {
                        System.out.println(o.getMesimdhenesi());
                    }
                }
            }
        }
        new PrintMesimDhenesit().print();

    }


    public OraEMesimit oraMaxStudent() throws FakultetiException {
        if (oretEMesimit.isEmpty()) {
            throw new FakultetiException("Orari eshte i zbrazet");
        }
        int sum = 0;
        OraEMesimit oraMax = null;
        for (int i = 0; i < oretEMesimit.size(); i++) {
            sum = sum + oretEMesimit.get(i).numriIStudenteve();
        }
        double avg = (double) sum / oretEMesimit.size();

        for (OraEMesimit oraEMesimit : oretEMesimit) {
            if ((oraMax == null && oraEMesimit.numriIStudenteve() > avg) || oraEMesimit.numriIStudenteve() > avg) {
                oraMax = oraEMesimit;
            }
        }

        if (oraMax == null) {
            System.out.println("Nuk ka asnje ore me numer te studenteve me te madh se mesatarja");
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            Fakulteti f = new Fakulteti("SHKI", 180, 6);
            Studenti s1 = new Studenti("A1C123", f, "12315678A", "Filan", "Fisteku", 'M');
            Studenti s2 = new Studenti("A2C123", f, "12325678A", "Filane", "Fisteku", 'F');
            Studenti s3 = new Studenti("A3C123", f, "12335678A", "Filan", "Filani", 'M');
            Studenti s4 = new Studenti("A4C123", f, "12345678A", "Filane", "Filani", 'F');
            Studenti s5 = new Studenti("A5C123", f, "12355678A", "Fistek", "Fisteku", 'M');
            Studenti s6 = new Studenti("A6C123", f, "12365678A", "Fisteke", "Filani", 'F');
            Studenti s7 = new Studenti("A7C123", f, "12375678A", "Fistek", "Filani", 'M');
            Profesori p = new Profesori(f, "12345678X", "Fatos", "Maxhuni", 'M');
            Asistenti a = new Asistenti(f, "12345678Y", "Besart", "Pllana", 'M');
            OraEMesimit om1 = new OraEMesimit(p, "Shkenca Kompjuterike 2");

            om1.shtoStudentin(s1);
            om1.shtoStudentin(s2);
            om1.shtoStudentin(s3);
            om1.shtoStudentin(s4);
            om1.shtoStudentin(s5);
            OraEMesimit om2 = new OraEMesimit(a, "Shkenca Komojuterike 2");
            om2.shtoStudentin(s1);
            om2.shtoStudentin(s2);
            om2.shtoStudentin(s3);
            om2.shtoStudentin(s4);
            om2.shtoStudentin(s5);
            om2.shtoStudentin(s7);
            om2.shtoStudentin(s6);

            Orari o = new Orari();
            o.shtoOret(om1);
            o.shtoOret(om2);

            String ll = "Ushtrime Praktike";
            System.out.println("Meshimedhenesit me angazhim: " + ll);
            o.shfletoMesimdhenesit(ll);
            OraEMesimit om = o.oraMaxStudent();
            if (om != null) {
                System.out.println();
                System.out.println("Ora me me shume student:\n" + om);
            }

        } catch (FakultetiException | PersoniException e) {
            e.printStackTrace();
        }

    }


}
