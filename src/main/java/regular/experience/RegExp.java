package regular.experience;

import interfaces.IDeclare;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp implements IDeclare {

    public static final String ANSWER = "([Yy][Ee][Ss])|([Nn][Oo])";
    public static final String YES = "yes";


    private static boolean test(String testString, String requiredPattern) {
        Pattern p = Pattern.compile(requiredPattern);
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static String checkOnCorrectValue(String message, String requiredPattern) {
        String testString;

        while (true) {
            System.out.print(message);
            testString = scan.next();
            if (!test(testString, requiredPattern)) {
                System.out.println("\nYou entered an incorrect value.\n\tTry it again!");
                testString = null;
                continue;
            } else return testString;
        }
    }

}
