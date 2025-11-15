package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        OptionalExample.emptyExample();
    }

}

// static method
// static method in interfaces
// interface default method
// lambda expression
// stream API
// Functional Interfaces
// Method Reference (static, object, Type, Constructor)
// Collectors
// ForEach() method
// Using forEach() with Parallel Streams
// Comparable and Comparator
// Date/Time API
// Nashorn JavaScript Engine
// URL and Filename Safe Encoding
// Base64 Encoding and Decoding
// MIME-Type Safe Encoding
// Parallel Array Sorting
// Type Annotations and Repeatable Annotations
// Concurrency Enhancements (CompletableFuture, Parallel Streams, StampedLock,
// ConcurrentAdders, Thread-sage Accumulators in ForkJoinPool)
// JDBC Enhancements (Addition of java.util.stream, Enhanced SQL Exception
// Handling, Support for Temporal Types in JDBC, improvements in
// CallableStatement and PreparedStatement)
// From Uma Charan Gorai on Medium

class OptionalExample {

    public static void emptyExample() {
        Optional<String> optional = Optional.empty();
        System.out.println(optional.get());
    }

    public static void optionalOf() {
        String str = new String("value");
        Optional<String> optional = Optional.of(str);
    }

}