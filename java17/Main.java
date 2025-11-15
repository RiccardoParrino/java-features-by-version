package java17;

public class Main {

    public static void main(String[] args) {
        InstanceOfImplicitCasting.after();
    }

}

/*
 * Performance enhancements:
 * Improvements to Z Garbage Collector:
 * lower latency: pause times < 1 ms (earlier 2-10ms), NUMA-aware allocation for
 * better CPU efficiency
 * better efficiency: Reduces Stop-The-World pauses, Thread Stack fully
 * concurrent
 * to use ZGC over Shenandoah GC: java -XX:+UseZGC -Xmx16G -jar myapp.jar
 * ZGC for cloud, AI, trading system and gaming
 * Shenandoah GC for cloud native, mid sized app, microservices
 */

class InstanceOfImplicitCasting {

    public static void after() {
        Object obj = "Hello from Java 17";
        if (obj instanceof String s) { // this also returns false for null values
            System.out.println(s);
        }
    }

    public static void before() {
        Object obj = "Hello from Java 17";
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s);
        }
    }

}

class RecordExample {

    record Point(int x, int y) {
    }

    public static void example() {
        Point p = new Point(10, 10);
        System.out.println(p.x());
        System.out.println(p.y());
    }

}

sealed class Vehicle permits Car, Bike {
}

final class Car extends Vehicle {
}

non-sealed class Bike extends Vehicle {
}

class ElectricBike extends Bike {
}