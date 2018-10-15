package Mixed.hoteli;

public abstract class Servisi {

    protected int cmimi;

    public Servisi(int cmimi) throws SkiException {
        if (cmimi <= 0) {
            throw new SkiException("Cmimi duhet te jete vlere pozitive dhe jo zero");
        }
    }

    abstract int cmimi();

}
