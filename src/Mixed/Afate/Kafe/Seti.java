package Mixed.Afate.Kafe;

import java.util.ArrayList;
import java.util.List;

public class Seti extends Artikulli {

    private List<Kombinimi> kombinimet;

    public Seti(String modeli, Lloji.llojiKafes lloji) throws ArtikulliException {
        super(modeli, 0.1, lloji);
        kombinimet = new ArrayList<>();
    }

    public void shtoKombinimin(Kombinimi kombinimi) throws ArtikulliException {
        if (kombinimi == null) {
            throw new ArtikulliException("Kombinimi eshte null");
        }
        if (!kombinimet.isEmpty() && !kombinimet.contains(kombinimi)) {
            throw new ArtikulliException("Kombinimet duhet te jene te njejtit lloj");
        }
        kombinimet.add(kombinimi);
    }

    @Override
    public double getCmimi() {
        double cmimi = 0;
        for (Kombinimi kombinimi : kombinimet) {
            cmimi = cmimi + kombinimi.getCmimi();
        }
        int size = kombinimet.size();
        int lirim = 0;
        if (size >= 4) {
            lirim = 20;
        } else if (size == 3) {
            lirim = 10;
        } else if (size == 2) {
            lirim = 5;
        }
        return cmimi * lirim / 100;
    }
}
