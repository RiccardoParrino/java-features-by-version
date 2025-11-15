import static java.lang.StringTemplate.STR;

public class StringLiteral {

    public static void main(String[] args) {
        SimpleExample.example();
    }
    // javac --enable-preview --release 21 StringLiteral.java
    // java --enable-preview StringLiteral

}

class SimpleExample {

    public static void example() {
        String name = "Riccardo";
        // String welcomeText = STR."Welcome from \{name}";
        // System.out.println(welcomeText);
    }

}