import java.util.Arrays;
import java.util.Collections;

public class Leetcode151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }
}
