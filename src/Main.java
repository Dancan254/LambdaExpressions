import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        List<String> names = new java.util.ArrayList<>(List.of("ian", "Dancan", "Peris", "Ann"));
        //method one without using lambda
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("************");
        //method 2 with lambda
        names.forEach(System.out::println);
        System.out.println("************");
        //method 3 with lambda
        names.forEach(System.out::println);
        System.out.println("************");
        names.forEach(name -> {
            char firstChar = name.charAt(0);
            System.out.println(name + " " + firstChar);
        });

        //using lambda to calculate
        int result = calculate(Integer::sum, 10, 20);
        var result2 = calculate((a, b)-> a * b, 10, 20);
        var result3 = calculate((a, b) -> a.toUpperCase() + b.toUpperCase(), "hello", "world") ;

        var coords = Arrays.asList(new double[]{1, 2}, new double[]{3, 4}, new double[]{5, 6});
        coords.forEach(cord -> System.out.println(Arrays.toString(cord)));

        //using Binary consumer
        System.out.println("************");
        coords.forEach(cord -> processPoint(cord[0], cord[1], (x, y) -> System.out.println(STR."x: \{x} y: \{y}")));
        
        names.removeIf(name -> name.equalsIgnoreCase("ian"));
        names.forEach(System.out::println);
        System.out.println("************");
        names.addAll(List.of("June", "July", "August"));
        names.removeIf(name -> name.startsWith("Ju"));
        names.forEach(System.out::println);
    }
    public static <T> T calculate(Operation<T> operation,T a, T b) {
        T result = operation.operate(a, b);
        System.out.println(STR."Result of operation \{result}");
        return result;
    }

    //using in built functional interfaces
    public static <T> T calculate2(BinaryOperator<T> operation, T a, T b) {
        T result = operation.apply(a, b);
        System.out.println(STR."Result of operation \{result}");
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static int doSomething(int a, int b){
       return a+b;
    }
}
