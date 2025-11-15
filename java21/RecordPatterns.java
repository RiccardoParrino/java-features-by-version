public class RecordPatterns {
    public static void main(String[] args) {
        System.out.println(DestructuringExample.afterExample(new Point(10, 10)));
    }
}

record Point(int x, int y) {
}

class DestructuringExample {

    public static int beforeExample(Object obj) {
        int sum = 0;
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            sum = x + y;
        }
        return sum;
    }

    public static int afterExample(Object obj) {
        if (obj instanceof Point(int x, int y)) {
            return x + y;
        }
        return 0;
    }

    /*
     * Similar to javascript destructuring
     * const person = {
     * firstName: "John",
     * lastName: "Doe",
     * age: 50
     * }
     * let {firstName, lastName} = person;
     */

}

// example with record inside another record and destructuring them
enum Color {
    RED, GREEN, BLUE
};

record ColoredPoint(Point point, Color color) {
}

record RandomPoint(ColoredPoint cp) {
}

class AnotherExample {

    public static Color getRandomPointColor(RandomPoint r) {
        if (r instanceof RandomPoint(ColoredPoint cp)) {
            return cp.color();
        }
        return null;
    }

}