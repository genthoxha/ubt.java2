package Mixed.fakulteti;

public abstract class Mesimdhenesi extends Personi implements Angazhoet{

    private final String EXT = "@fakulteti.edu";
    private String email;
    private Fakulteti fakulteti;

    public Mesimdhenesi(Fakulteti fakulteti,String nP, String e, String mb, char gj) throws PersoniException {
        super(nP, e, mb, gj);
        this.email = e + "." + mb + this.EXT;
        this.fakulteti = fakulteti;
    }

    public String getEmail() {
        return email;
    }
    public String toString() {
        return super.toString() + " " + email;
    }

    public Fakulteti getFakulteti() {
        return fakulteti;

    }
}
