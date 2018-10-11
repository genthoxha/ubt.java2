package Mixed.skijatori;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Gara {
    private String emri;
    private Disciplina.Alpin disciplina;
    private List <Skijatori> skijatoret;
    private HashMap <Integer, List <Skijatori>> rezulati;
    private Random rand;

    public Gara(String emri, Disciplina.Alpin disc) throws FISEException {
        if(Util.isEmpty(emri)) {
            throw new FISEException("emri i vendit te gares eshte i zbrazte");
        }
        if(disc == null){
            throw new FISEException("Disciplina eshte NULL");
        }
        this.emri = emri;
        this.disciplina = disc;
        skijatoret = new ArrayList<>();
        rezulati = new HashMap<>();
        rand = new Random();

    }

    public void shtoSkijatoin(Skijatori skijatori) throws FISEException {
        if(skijatori == null) {
            throw new FISEException("Skijatori eshte NULL");
        }

        if(!skijatori.iTakonDisciplines(disciplina)) {
            throw new FISEException("Skijatori nuk i takon gares");
        }

        if(skijatoret.contains(skijatori)) {
            throw new FISEException("Skijatori eshte ne liste");
        }
        skijatoret.add(skijatori);
    }

    public void startoGaren(){
        Iterator <Skijatori> it = skijatoret.iterator();
        while(it.hasNext()) {
            Skijatori skijatori = it.next();
            int koha = kohaELeshimit();
            System.out.println(skijatori+" filloi leshimin "+koha );
            try {
                Thread.sleep(koha * 100);
            } catch (InterruptedException ex) {
            }
            it.remove();
            if(koha < 10) {
                System.out.println(skijatori+" u rrezua");
            } else {
                System.out.println(skijatori+" perfundoi leshimin per "+koha+" sekonda");
                List <Skijatori> skijatorerPerKohe = rezulati.get(koha);
                if(skijatorerPerKohe == null) {
                    skijatorerPerKohe = new ArrayList<>();
                }
                skijatorerPerKohe.add(skijatori);
                rezulati.put(koha, skijatorerPerKohe);
            }
        }
    }

    public boolean garaKaPerfunduar(){
        return skijatoret.isEmpty();
    }

    public Skijatori ktheFituesin() {
        if(!garaKaPerfunduar()) {
            return null;
        }
        Set <Integer> set = rezulati.keySet();
        if(set.isEmpty()) {
            return null;
        }
        Integer [] arr = new Integer[set.size()];
        arr = set.toArray(arr);
        Arrays.sort(arr);
        //ose 
//        List <Integer> keys = new ArrayList<>(set);
//        Collections.sort(keys);
//        Integer ePara = keys.get(0);

        List <Skijatori> skijatorerPerKohe = rezulati.get(arr[0]);
        Collections.sort(skijatorerPerKohe);
        return skijatorerPerKohe.get(0);
    }

    public void populloPrejFile() throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("F:/skijatoret.txt"))){
            String rreshti;
            while((rreshti = br.readLine()) != null){
                try {
                    Skijatori skijatori = ndertoNgaRreshti(rreshti);
                    if(skijatori != null) {
                        skijatoret.add(skijatori);
                    }
                }
                catch(FISEException fe) {
                    System.out.println("Nuk u shtua: "+rreshti);
                }
            }
        }
    }

    private Skijatori ndertoNgaRreshti(String rreshti) throws FISEException{
        String [] params = rreshti.split(",");
        Skijatori skijatori = null;
        if(params.length == 4) {
            try {
                int shifra = Integer.parseInt(params[0]);
                String emriStr = params[1].trim();
                String shteti = params[2].trim();
                skijatori = new Skijatori(shifra,emriStr,shteti);
                String disciplinaStr = params[3].trim();
                String [] disciplinat = disciplinaStr.split(":");
                for (String disc : disciplinat) {
                    switch(disc) {
                        case "D":
                            skijatori.shtoDisciplinen(Disciplina.Alpin.Downhill);
                            break;
                        case "S":
                            skijatori.shtoDisciplinen(Disciplina.Alpin.Slalom);
                            break;
                        case "GS":
                            skijatori.shtoDisciplinen(Disciplina.Alpin.GiantSlalom);
                            break;
                    }
                }
            } catch(NumberFormatException nfe){}
        }
        return skijatori;
    }

    private int kohaELeshimit(){
        return rand.nextInt(60);
    }

    public static void main(String[] args) {
        try {
            Gara gara = new Gara("Schladming", Disciplina.Alpin.Slalom);
            gara.populloPrejFile();
            gara.startoGaren();
            gara.ndertoNgaRreshti("5,Zahir,VUS,S");
            System.out.println("Fituesi = " + gara.ktheFituesin());
        } catch (FISEException | IOException ex) {
            System.out.println(ex);
        }
    }
}