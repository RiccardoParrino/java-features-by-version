package java11;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        NotPredicateExample.example();
    }

}

// performance enhancements:
/*
 * New intrisics for Math.sin, Math.cos and Math.log function for ARM64
 * (JVM instrisics are special optimized implementation of certain methods:
 * which method is an intrisic and how it is implemented depends on JVM version
 * (Java 8 vs Java 11), JVM vendor (OpenJDK, OracleJDK) and the hardware
 * architecture (ARM64, AMD64...))
 * new Epsilon Garbage Collector (not collect any garbage)
 * Java Flight Recorder
 * java FX removed
 */

class NestedClassesExample {

    class InnerClassExample {
        private String innerPrivateAttribute;
    }

    public static void nestMatesExample() {
        System.out.println(InnerClassExample.class.isNestmateOf(NestedClassesExample.class));
        for (Field f : InnerClassExample.class.getDeclaredFields()) {
            System.out.println(f.getName());
        }
    }

    public static void nestHostExample() {
        System.out.println(InnerClassExample.class.getNestHost().getSimpleName());
    }

}

class HttpClientExample {

    public static void example() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8080/api/name"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

}

class NotPredicateExample {

    public static void example() {
        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        withoutBlanks.forEach(System.out::println);
    }

}

class VarLambdaExpressionExample {

    public static void example() {
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String resultString = sampleList.stream()
                .map((@NonNull var x) -> x.toUpperCase()) // using var is possible to add lambda expression parameters
                .collect(Collectors.joining(", "));
        System.out.println(resultString);
    }

}

class CollectionToArrayExample {

    public static void example() {
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new); // new method
        for (String s : sampleArray) {
            System.out.println(s);
        }
    }

}

class NewFileMethodsExample {

    public static void example() throws IOException {
        Path newFile = Files.createTempFile("demo", ".txt");
        Path filePath = Files.writeString(newFile, "Sample text"); // new method
        String fileContent = Files.readString(filePath); // new method
        System.out.println(fileContent);
    }

}

class NewStringMethodsExample {

    public static void examples() {
        String s = new String(" first line\nsecond line ");
        System.out.println(s.isBlank());
        s.lines().forEach(System.out::println);
        System.out.println(s.strip());
        System.out.println(s.stripLeading());
        System.out.println(s.stripTrailing());
    }

}