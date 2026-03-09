import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupStringOnFirstLetter {
    public void groupStringOnFirstLetter() {
        List<String> data = Arrays.asList("apple", "banana", "apricot");

        Map<Character, List<String>> charGroup = data.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println(charGroup);

        Map<Character, List<String>> charGroupMap = data.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> new ArrayList<>(List.of(s)),
                        (existing, replacement) -> {
                            existing.addAll(replacement);
                            return existing;
                        }
                ));
        System.out.println(charGroupMap);
    }

}
