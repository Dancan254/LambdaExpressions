import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class MethodReferences {
    public static void main(String[] args) {
        //before using method reference
        BinaryOperator<String> b3 = (s1, s2) -> s1.concat(s2);
        System.out.println(b3.apply("Hello", "World"));

        //applying methode reference
        BinaryOperator<String> b1 = String::concat;
        System.out.println(b1.apply("Hello", "World"));
        BiFunction<String, String, String> b2 = String::concat;
        System.out.println(b2.apply("Hello", "World"));
        UnaryOperator<String> u1 = String::toUpperCase;
        System.out.println(u1.apply("hello"));
    }
}
