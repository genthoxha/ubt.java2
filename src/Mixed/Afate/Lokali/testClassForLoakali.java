package Mixed.Afate.Lokali;

import org.junit.Test;

import java.util.Objects;

public class testClassForLoakali {

    @Test
    public void testSmth() throws EventException {
        Lokali l = new Lokali("A", 21);
        System.out.println(Objects.hashCode(l.getEmri()));
        System.out.println(l.hashCode());

    }

}
