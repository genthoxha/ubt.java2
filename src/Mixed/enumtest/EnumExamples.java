package Mixed.enumtest;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumExamples {

    public static void main(String[] args) {
        Level level = Level.MEDIUM;

        Level high = Level.valueOf("HIGH");
//        System.out.println(high);
//        System.out.println(high.getLevel());

  /*      System.out.println(Level.HIGH.normalize());
        System.out.println(Level.MEDIUM.normalize());
        System.out.println(Level.LOW.normalize());


        EnumSet enumSet = EnumSet.of(Level.HIGH, Level.MEDIUM);
        System.out.println(enumSet);*/

        EnumMap<Level, String> enumMap = new EnumMap<Level, String>(Level.class);
        enumMap.put(Level.HIGH, "High value");
        enumMap.put(Level.LOW, "Low value");
        enumMap.put(Level.MEDIUM, Level.MEDIUM.normalize());

        System.out.println(enumMap);
    }

}
