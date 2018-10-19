package Mixed.setshashsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);

            System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");
            Set<Integer> union = new HashSet<>(squares);
            union.addAll(cubes);
            System.out.println("Union contains " + union.size() + " elements");

            Set<Integer> intersection = new HashSet<>(squares);
            intersection.retainAll(cubes);
            System.out.println("Intersection contains " + intersection.size() + " elements");

            for (int j : intersection) {
                System.out.println(j + "is the square of " + Math.sqrt(j) + " and the cube of " + Math.cbrt(j));
            }

            Set<String> words = new HashSet<>();
            String sentence = "one day in the year of the fox";
            String[] arrayWords = sentence.split(" ");
            words.addAll(Arrays.asList(arrayWords));

            for (String s : words) {
                System.out.println(s);
            }

            Set<String> nature = new HashSet<>();
            Set<String> divine = new HashSet<>();

            String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "the"};
            nature.addAll(Arrays.asList(natureWords));


            String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
            divine.addAll(Arrays.asList(divineWords));

            System.out.println("nature - divine: ");
            Set<String> diff1 = new HashSet<>(nature);
            diff1.removeAll(divine);
            printSet(diff1);

            System.out.println("divine - nature: ");
            Set<String> diff2 = new HashSet<>(divine);
            diff2.removeAll(nature);
            printSet(diff2);

            Set<String> unionTest = new HashSet<>(nature);
            unionTest.addAll(divine);
            Set<String> intersectionTest = new HashSet<>(nature);
            intersectionTest.addAll(divine);

            System.out.println("Symmetric difference: ");
            unionTest.removeAll(intersectionTest);
            printSet(unionTest);


            if (nature.containsAll(divine)) {
                System.out.println("divine is a subset of nature");
            }

            if (nature.containsAll(intersectionTest)) {
                System.out.println("intersaction is subset of nature");
            }
            if (divine.containsAll(intersectionTest)) {
                System.out.println("intersection is a subset of divine");
            }
        }


    }
    private static void printSet(Set<String> set){
        System.out.println("\t");
        for (String s : set) {
            System.out.println(s + " ");
        }
        System.out.println();
    }
}
