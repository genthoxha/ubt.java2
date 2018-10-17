package Mixed.fakulteti;
public class Studenti extends Personi {
    private String ID;
    private Fakulteti fakulteti;

    public Studenti(String ID, Fakulteti fakulteti, String numriPersonal, String emri, String mbiemri, char gjinia) throws PersoniException {
        super(numriPersonal, emri, mbiemri, gjinia);
        if(ID == null || ID.trim().isEmpty()) {
            throw new PersoniException("ID e studentit e zbrazet");
        }

        if(fakulteti == null) {
            throw new PersoniException("Fakulteti i pa inicializuar");
        }
        this.ID = ID;
        this.fakulteti = fakulteti;
    }

    public String getID() {
        return ID;
    }

    public Fakulteti getFakulteti() {
        return fakulteti;
    }

    public String kaRolin() {
        return "Student";
    }

    public String toString() {
        return "Studenti " + super.toString() + " me ID " + ID;
    }
}
