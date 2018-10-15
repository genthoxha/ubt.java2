package Mixed.hoteli;

public class Fjetja extends Servisi {

    private int ditet;

    public Fjetja(int cmimi, int ditet) throws SkiException {
        super(cmimi);
        this.ditet = ditet;
    }

    public int cmimi() {
        return ditet * cmimi;
    }

}
