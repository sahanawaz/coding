import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class CapitalizeFirstLetter {
    String readInputFromUser() {
        return IO.readln("Enter a sentence: ");
    }

    void printCapitalizedOutput(String sentence) {
        IO.println("===== Capitalized Output =====");
        IO.println(sentence);
    }

    String capitalizeWords(String sentence) {
        if (Objects.isNull(sentence) || sentence.trim().isEmpty())
            return "";

        LinkedList<String> words = Arrays.stream(sentence.trim().split("\\s+"))
                .collect(Collectors.toCollection(LinkedList::new));

        StringBuilder capitalized = new StringBuilder();
        for (String word: words) {
            capitalized.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }

        // Trim to remove the last space added in the above loop
        return capitalized.toString().trim();
    }

    String capitalizeUsingStream(String sentence) {
        if (Objects.isNull(sentence) || sentence.isBlank())
            return "";

        return Arrays.stream(sentence.trim().split("\\s+"))
                .map(word -> {
                    StringBuilder sb = new StringBuilder(word.length());
                    sb.append(Character.toUpperCase(word.charAt(0)));
                    if(word.length() > 1) {
                        sb.append(word.substring(1).toLowerCase());
                    }
                    return sb.toString();
                })
                .collect(Collectors.joining(" "));
    }
}
