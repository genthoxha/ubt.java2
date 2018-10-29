package Mixed.Afate.Lokali;

import java.util.Objects;

public abstract class Artikulli {

    private int cmimi;

    public Artikulli(int cmimi) throws EventException {
        if (cmimi < 0) {
            throw new EventException("Artikulli: Cmimi nuk duhet te jete vlere negative!");
        }
        this.cmimi = cmimi;
    }

    public int getCmimi() {
        return cmimi;
    }

    @Override
    public int hashCode() {
        int hashCode = 8;
        hashCode = hashCode + Objects.hashCode(cmimi);
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Artikulli) {
            Artikulli a = (Artikulli) obj;
            return cmimi == a.getCmimi();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Artikulli ka cmimin: " + cmimi;
    }
}
