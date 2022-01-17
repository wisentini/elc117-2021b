import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerStreams {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> newIntegers = integers
            .stream()
            .map((Integer integer) ->
                (integer % 2 == 0) ? -integer : integer * 2
            )
            .collect(
                Collectors.toList()
            );

        newIntegers.forEach(integer ->
            System.out.println(integer
        ));
    }
}
