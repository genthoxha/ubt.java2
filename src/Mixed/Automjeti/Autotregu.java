package Mixed.Automjeti;

import java.util.Hashtable;

public class Autotregu {

    private String emri;
    private Hashtable<String,Automjeti> automjetetHashtable;

    public Autotregu(String emri) throws AutomjetiException {
        if (emri == null || emri.trim().equals("")) {
            throw new AutomjetiException("Emri autotregut nuk duhet te jete i zbrazet");
        }
        this.emri = emri;
        automjetetHashtable = new Hashtable<>();
    }

    public String getEmri() {
        return emri;
    }

    public void shtoAutomjetin(Automjeti a) throws AutomjetiException {
        if (a == null) {
            throw new AutomjetiException("Automjeti nuk eshte i inicializuar");
        }
        if (automjetetHashtable.containsKey(String.valueOf(a.getNrShasise()))) {
            throw new AutomjetiException("Automjeti egziston");
        }
        automjetetHashtable.put(String.valueOf(a.getNrShasise()), a);
    }


    public boolean egziston(int nrS) throws AutomjetiException {
         if (nrS <= 0) {
             throw new AutomjetiException("ISBN i librit duhet te jete pozitiv!");
         }
         return automjetetHashtable.containsKey(String.valueOf(nrS));
    }

    public boolean fshijeAtuomjetin(int nrS) throws AutomjetiException {
        if (egziston(nrS)) {
            automjetetHashtable.remove(nrS);
            throw new AutomjetiException("Automjeti u fshije me sukses");
        } else {
            throw new AutomjetiException("Automjeti nuk egziston");
        }
    }

    public static void main(String[] args) {
        try {
            Autotregu autotregu = new Autotregu("Tregu XYZ");
            autotregu.shtoAutomjetin(new Automjeti(11345, "BMW", 2010));
            autotregu.shtoAutomjetin(new Automjeti(22345, "M BENZ", 2012));
            autotregu.shtoAutomjetin(new Automjeti(32345, "GOLF", 2010));
            autotregu.shtoAutomjetin(new Automjeti(42345, "OPEL", 2012));
            autotregu.shtoAutomjetin(new Automjeti(52345, "FIAT", 2011));
            autotregu.shtoAutomjetin(new Automjeti(11345, "AUDI 1", 2005));
            autotregu.shtoAutomjetin(new Automjeti(21345, "Peugeot", 2010));
            autotregu.shtoAutomjetin(new Automjeti(22375, "Renault Clio", 2012));
            autotregu.shtoAutomjetin(new Automjeti(31345, "BMW", 2012));

            System.out.println();
            if (autotregu.egziston(11345)) {

                System.out.println("Test: Libri me isbn 11345 ekziston.");
            } else {
                System.out.println("Test: Libri me isbn 11345 nuk ekziston.");
            }
            System.out.println();
            if (autotregu.fshijeAtuomjetin(11345)) {
                System.out.println("Test: Libri me isbn 11345 eshte fshire.");
            } else {
                System.out.println("Test: Libri me isbn 11345 nuk eshte fshire.");
            }
            System.out.println();
            if (autotregu.egziston(11345)) {
                System.out.println("Test: Libri me isbn 11345 ekziston.");
            } else {
                System.out.println("Test: Libri me isbn 11345 nuk ekziston.");
            }



        } catch (AutomjetiException ae) {
        }
    }

}
