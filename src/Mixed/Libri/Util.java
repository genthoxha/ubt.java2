package Mixed.Libri;

public class Util {

    public static boolean isEmpty(String s) {
        if (s == null && s.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
