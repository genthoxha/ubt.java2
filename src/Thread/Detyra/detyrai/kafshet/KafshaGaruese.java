package Thread.Detyra.detyrai.kafshet;

public abstract class KafshaGaruese extends Thread{
    private int mosha;
    private String emri;
    private int pozitaStartuese;

    public KafshaGaruese(int mosha, String emri, int pozitaStartuese) throws GaraException {
        if(emri == null || emri.trim().isEmpty())
            throw new GaraException("Emri i zbrazet!");
        if(pozitaStartuese <= 0)
            throw new GaraException("Pozita duhet pozitive!");
        this.mosha = mosha;
        this.emri = emri;
        this.pozitaStartuese = pozitaStartuese;
    }

    public int getMosha() {
        return mosha;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public int getPozitaStartuese() {
        return pozitaStartuese;
    }

    public void setPozitaStartuese(int pozitaStartuese) {
        this.pozitaStartuese = pozitaStartuese;
    }
    public String toString(){
        return "(" + getClass().getSimpleName() + ") " + emri;
    }

    public boolean equals (Object obj){
        return obj instanceof KafshaGaruese && emri.equals(((KafshaGaruese)obj).getEmri());
    }
}
