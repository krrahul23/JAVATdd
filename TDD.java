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

        String[] numberStrings = numbersWithoutDelimiter.split(Pattern.quote(delimiter));
        int[] numbersInt = new int[numberStrings.length];
        StringBuilder negativeNumbers = new StringBuilder();

        for (int i = 0; i < numberStrings.length; i++) {
            int number = Integer.parseInt(numberStrings[i].trim());
            if (number < 0) {
                negativeNumbers.append(number).append(",");
            }
            numbersInt[i] = number;
        }

        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException(
                    "negative numbers not allowed: " + negativeNumbers.substring(0, negativeNumbers.length() - 1));
        }

        return Arrays.stream(numbersInt).sum();
    }

    public static void main(String[] args) {
        int ans = add("1,2,3");
        System.out.println(ans);
    }
}