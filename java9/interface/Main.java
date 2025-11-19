public class Main {
    public static void main(String[] args) {
        System.out.println(
                StringUtil.toLowerCase("null"));
    }
}

interface StringUtil {
    static String toUpperCase(String input) {
        validate(input);
        return input.toUpperCase();
    }

    static String toLowerCase(String input) {
        validate(input);
        return input.toLowerCase();
    }

    private static void validate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }
}