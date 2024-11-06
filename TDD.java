import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TDD {
    public static int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        String delimiter = ",";
        String numbersWithoutDelimiter = numbers;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        if (m.find()) {
            delimiter = m.group(1);
            numbersWithoutDelimiter = m.group(2);
        }
        return 0;
    }

    public static void main(String[] args) {
        int ans = add("");
        System.out.println(ans);
    }
}