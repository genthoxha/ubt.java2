package Mixed.fakulteti;

public class Studenti extends Personi  {

    private int id;

    public Studenti(String np,String e,String mb,char gj,int id) throws FakultetiException {
        super(np,e,mb,gj);
        if (id <= 0) {
            throw new FakultetiException("Id nuk duhet te jete e zbrazet");
        }
        this.id = id;
    }

    public String kaRolin() {
        return "Student";
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return super.toString() + " " + id;
    }
}
