import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MiniChallenges {
    void main(String[] args) {
        /*
        *convert to a lambda expressions
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] words = s.split(" ");
                for (String word : words) {
                    System.out.println(word);
                }
            }
        };
         */
        Consumer<String> printWords = sentence -> {
            String[] word = sentence.split(" ");
            for (String s : word) {
                System.out.println(s);
        }
    };
        printWords.accept("Hello there, how are you?");
        //using lambda expression
        Consumer<String> printWordsLambda = sentence -> {
            String[] word = sentence.split(" ");
            Arrays.asList(word).forEach(System.out::println);
        };
        printWordsLambda.accept("Hello there, how are you?");

        //using lambda expression concise way
        Consumer<String> printWordsLambdaConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(System.out::println);
        };
        printWordsLambda.accept("Hello there, how are you?");

        //challenge 2
        Function<String, String> secondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        //alternatively
        UnaryOperator<String> secondCharacter = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(secondChar.apply("1234567890"));

        String result = secondCharacter("1234567890", source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        });
        System.out.println(result);


    }


    //challenge 2
    //write the method to a lambda
    public static String everySecondChar(String source){
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String secondCharacter(String source, UnaryOperator<String> unaryOperator){
        return unaryOperator.apply(source);
    }
}
