package java.hw_140521.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDomen {
    public static void main(String[] args) {
        String text = "http://example.com/";
        String  PATTERNexp =
                "^(https?)://([a-z]{1,}.)([a-z]{2,6})/$";

        Pattern pattern = Pattern.compile(PATTERNexp);
        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.find());
    }
}
