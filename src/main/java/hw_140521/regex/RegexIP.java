package java.hw_140521.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexIP {
    public static void main(String[] args) {
        String text = "127.0.0.255";
        String PATTERNexp =
                "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$";

        Pattern pattern = Pattern.compile(PATTERNexp);
        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.find());
    }
}
