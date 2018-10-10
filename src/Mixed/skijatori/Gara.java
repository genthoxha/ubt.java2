package Mixed.skijatori;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Gara {
    private String emri;
    private Disciplina.Alpin disciplina;
    private List<Skijatori> skijatoret;
    private HashMap<Integer,List<Skijatori>> rezultati;
    private Random random;

    public Gara(String e, Disciplina.Alpin disciplina)throws FISEException {
        if (e == null || Util.isEmpty(e)) {
            throw new FISEException("Emri i vendit te gares eshte i zbrazte");
        }
        if (disciplina == null) {
            throw new FISEException("Emri i disciplines se gares eshte i zbrazte");
        }
        this.emri = emri;
        skijatoret = new ArrayList<>();
        this.disciplina = disciplina;
        rezultati = new HashMap<>();
        random = new Random();
    }

    public void shtoSkijatorin(Skijatori skijatori)throws FISEException{
        if (skijatori == null) {
            throw new FISEException("Skijatori eshte NULL");
        }
        if (!skijatori.iTakonDisciplines(disciplina)) {
            throw new FISEException("Skijatori nuk i takon disciplines");
        }
        if (skijatoret.contains(skijatori)) {
            throw new FISEException("Skijatori gjendet ne varg");
        }
        skijatoret.add(skijatori);
    }

    











}
