package Mixed.pajisja;

import java.util.ArrayList;

public class PajisjaKomunikuese {

    private ArrayList<Pajisja> list;

    public PajisjaKomunikuese() {
        list = new ArrayList<>();
    }
    public void shtoPaisjen(Pajisja p)throws PajisjaException {
        if (p == null) {
            throw new PajisjaException("NULL");
        }
        if (list.contains(p))
            throw new PajisjaException("Ekziston");
        list.add(p);
    }

    public void printo() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        try {
            PajisjaKomunikuese p = new PajisjaKomunikuese();
            TelefoniMobil q1 = new TelefoniMobil("Galaxy S7", "fsd5f1df8", true);
            TelefoniMobil q2 = new TelefoniMobil("Galaxy S5", "845114df5",true);
            TelefoniMobil q3 = new TelefoniMobil("Samsung I3210", "dasadad84",false);
            Kompjuteri q4 = new Kompjuteri("Dell", "QEERD5555");
            Kompjuteri q5 = new Kompjuteri("ASUS", "FFSFS9955");
            Kompjuteri q6 = new Kompjuteri("Lenovo", "GDFKFF54F");
            p.shtoPaisjen(q1);
            p.shtoPaisjen(q2);
            p.shtoPaisjen(q3);
            p.shtoPaisjen(q4);
            p.shtoPaisjen(q5);
            p.shtoPaisjen(q6);
        } catch (PajisjaException e) {
            e.printStackTrace();
        }
    }


}
