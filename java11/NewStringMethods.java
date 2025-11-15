package java11;

public class NewStringMethods {
    public static void main(String[] args) {
        Example.examples();
    }
}

class Example {

    public static void examples() {
        String s = new String(" first line\nsecond line ");
        System.out.println(s.isBlank());
        s.lines().forEach(System.out::println);
        System.out.println(s.strip());
        System.out.println(s.stripLeading());
        System.out.println(s.stripTrailing());
    }

}