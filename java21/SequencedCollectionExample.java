import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SequencedMap;
import java.util.SequencedSet;

public class SequencedCollectionExample {

    public static void main(String[] args) {
        SequencedMapImplementation.example();
    }

}

class SequencedMapImplementation {

    public static void example() {
        SequencedMap<Integer, String> sm = new LinkedHashMap<>();
        sm.put(1, "one");
        sm.put(2, "two");
        sm.put(3, "three");

        sm.putFirst(4, "four");
        sm.putLast(0, "zero");

        SequencedMap<Integer, String> reversedSM = sm.reversed();

        sm.entrySet().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        reversedSM.entrySet().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }

}

class SequencedSetImplementation {

    public static void example() {
        SequencedSet<Integer> ss = new LinkedHashSet<>();

        ss.add(1);
        ss.add(2);
        ss.add(3);

        ss.forEach(System.out::println);

        System.out.println(ss.getFirst());
        System.out.println(ss.getLast());
    }

}