import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        StreamEnhancementExample.collectorsFilteringExample();
    }

}

class StreamEnhancementExample {
    // new method added
    // takeWhile
    // dropWhile
    // ofNullable
    // iterate
    // Collectors.filtering
    // Collectors.flatMapping
    // Collectors.collectingAndThen

    public static void takeWhileExample() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.takeWhile(n -> n < 5).forEach(System.out::println);
    }

    public static void dropWhileExample() {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.dropWhile(n -> n < 5).forEach(System.out::println);
    }

    public static void ofNullableExample() {
        // Avoid null checks when creating streams
        // like Optional but with Stream
        Stream<String> nonNullStream = Stream.ofNullable("Hello");
        nonNullStream.forEach(System.out::println);

        Stream<String> nullStream = Stream.ofNullable(null);
        nullStream.forEach(System.out::println);
    }

    public static void iterateExample() {
        Stream.iterate(1, n -> n <= 10, n -> n + 1)
                .forEach(System.out::println);
    }

    public static void collectorsFilteringExample() {
        List<String> names = Stream.of("Alice", "Bob", "Charlie", "David")
                .collect(Collectors.filtering(name -> name.startsWith("A"), Collectors.toList()));
        System.out.println(names);
    }

}

class FlatMapExample {

    public static void exampleFlatMap() {
        List<String> words = List.of("hi", "bye");
        List<String> chars = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .toList();
        System.out.println(chars);
    }

    public static void exampleMap() {
        List<String> words = List.of("hi", "bye");
        List<Stream<String>> chars = words.stream()
                .map(word -> Arrays.stream(word.split("")))
                .toList();
        chars.forEach(stream -> stream.forEach(System.out::print));
    }

}
