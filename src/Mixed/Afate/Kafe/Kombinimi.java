package Mixed.Afate.Kafe;

public final class Kombinimi {
    private Filxhani filxhani;
    private Tabaku tabaku;
    private Luga luga;

    public Kombinimi(Filxhani filxhani, Tabaku tabaku, Luga luga) throws ArtikulliException{
        if(filxhani == null || tabaku == null || luga == null) {
            throw new ArtikulliException("S'ka kokmbinim");
        }

        if(!iNjejtiModelLloj()){
            throw new ArtikulliException("Kombimi duhet te kete te njejtin model");
        }
        this.filxhani = filxhani;
        this.tabaku = tabaku;
        this.luga = luga;
    }

    private boolean iNjejtiModelLloj(){
        return filxhani.equals(tabaku) && filxhani.equals(luga);
    }

    public double getCmimi(){
        return filxhani.getCmimi() + tabaku.getCmimi() + luga.getCmimi();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Kombinimi) {
            final Kombinimi other = (Kombinimi)obj;
            return filxhani.equals(other.filxhani) && tabaku.equals(other.tabaku) && luga.equals(other.luga);
        }
        return false;
    }
}
