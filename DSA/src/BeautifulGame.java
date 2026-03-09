import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BeautifulGame {
    /**
     * A String s is considered "beautiful" if, for every character from 'A' to 'Z',
     * all occurrences of that specific character form a single contiguous substring.
     * Example
     * BEAUTIFUL: "AAABBBCCCD" (all A's are together, all B's are together, etc)
     * NOT BEAUTIFUL: "AABBAA" ( The A's are split by B's so they don't form a single contiguous substring)
     */

    public boolean lookForBeautiful(String argStr) {
        boolean isBeautiful = true;
        Set<Character> seenChar = new HashSet<>();
        int len = argStr.length();
        for (int i=0; i<len; i++) {
            boolean isAddedToSet = seenChar.add(argStr.charAt(i));
            if(i > 0 && !isAddedToSet && (argStr.charAt(i) != argStr.charAt(i-1))) {
                isBeautiful = false;
                break;
            }
        }
        return isBeautiful;
    }

    public void runTest() {
        Object[][] testCases = {
                {"", true},
                {"A", true},
                {"AAAAA", true},
                {"ABCDE", true},
                {"AABBCC", true},
                {"ABA", false},
                {"AABBCB", false},
                {"AABBCCAA", false},
                {"12CC", true},
                {"aaAABBbb", true}
        };

        for (Object[] row: testCases) {
            boolean expected = (boolean) row[1];
            boolean actual = lookForBeautiful((String) row[0]);

            if (expected == actual) {
                System.out.println("Test Case: " + Arrays.toString(row) + " : PASSED");
            } else {
                System.out.println(("Test Case: " + Arrays.toString(row) + " : FAILED"));
            }
        }
    }
}
