package Mixed.fakulteti;

public class Fakulteti {
    private String drejtimi;
    private int nrKredive;
    private int nrSemestrave;

    public Fakulteti(String drejtimi, int nrKredive, int nrSemestrave) throws FakultetiException {
        if (Util.isEmpty(drejtimi)) {
            throw new FakultetiException("Drejtimi nuk duhet te jete null");
        }
        if (nrKredive < 0) {
            throw new FakultetiException("NR. kredive nuk duhet te jete negativ");
        }
        if (nrSemestrave < 0) {
            throw new FakultetiException("NR. semestrave nuk duhet te jete negativ");
        }

        this.drejtimi = drejtimi;
        this.nrKredive = nrKredive;
        this.nrSemestrave = nrSemestrave;
    }

    public String getDrejtimi() {
        return drejtimi;
    }

    public int getNrKredive() {
        return nrKredive;
    }

    public int getNrSemestrave() {
        return nrSemestrave;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fakulteti) {
            Fakulteti fakulteti = (Fakulteti) obj;
            return drejtimi.equals(fakulteti.getDrejtimi()) && nrKredive == fakulteti.getNrKredive() &&
                    nrSemestrave == fakulteti.getNrSemestrave();
        }
        return false;
    }
}
