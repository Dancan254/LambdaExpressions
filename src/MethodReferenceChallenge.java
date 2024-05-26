import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class MethodReferenceChallenge {

    public static void main(String[] args) {
        //create an array of names
        String[] names = {"ian", "Dancan", "Peris", "Ann"};
        //create a list of unary operators
        List<UnaryOperator<String>> operations = List.of(
               String::toUpperCase,
                String::toLowerCase
        );
        applyChanges(names, operations);
    }

    private static  void applyChanges(String[] names, List<UnaryOperator<String>> operations) {
        List<String> backedString = Arrays.asList(names);
        for (UnaryOperator<String> operation : operations) {
            backedString.replaceAll(s -> s.transform(operation));
            System.out.println(Arrays.toString(names));
        }
    }
}
