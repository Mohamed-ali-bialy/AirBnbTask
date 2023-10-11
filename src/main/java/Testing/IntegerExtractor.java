package Testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class IntegerExtractor {
    public static Integer extractIntegerFromString(String inputString) {
        // Create a regular expression pattern to match integers
        Pattern pattern = Pattern.compile("\\d+");

        // Create a matcher for the input string
        Matcher matcher = pattern.matcher(inputString);

        // Check if a match is found
        if (matcher.find()) {
            // Extract the matched integer and parse it
            String integerStr = matcher.group();
            return Integer.parseInt(integerStr);
        } else {
            // Return null if no integer is found in the string
            return null;
        }
    }

    public static void main(String[] args) {
        String inputString = "5 bedrooms";
        Integer result = extractIntegerFromString(inputString);

        if (result != null) {
            System.out.println("The extracted integer is: " + result);
        } else {
            System.out.println("No integer found in the input string.");
        }
    }
}
