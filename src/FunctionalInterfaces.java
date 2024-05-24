import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        List<String> places = new ArrayList<>(List.of("Nairobi", "Kisumu", "Mombasa", "Nakuru"));
        places.replaceAll(place -> STR."\{place.charAt(0)} _ \{place.toUpperCase()}");
        places.forEach(System.out::println);

        //setAll method
        String[] emptyStrings = new String[10];
        Arrays.setAll(emptyStrings, i -> STR."\{i + 1} ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, i -> STR."\{i + 1} " +
                switch (i){
                    case 0 -> "st";
                    case 1 -> "nd";
                    case 2 -> "rd";
                    default -> "th";
                });
        System.out.println(Arrays.toString(emptyStrings));

        //supplier
        String[] values = {"a", "b", "c", "d", "e"};
        String[] randomList = randomlySelectedValues(10, values, () -> new Random().nextInt(values.length));
        System.out.println(Arrays.toString(randomList));
    }
    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            int index = s.get();
            result[i] = values[index];
        }
        return result;
    }
}
