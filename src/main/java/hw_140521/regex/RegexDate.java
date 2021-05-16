package java.hw_140521.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String PATTERNexp =
                "(19|20)\\d\\d/((0[1-9]|1[012])/(0[1-9]|[12]\\d)|(0[13-9]|1[012])/30|(0[13578]|1[02])-31)( )([0-1]\\d|2[0-3])(:[0-5]\\d){2}$";

        Pattern pattern = Pattern.compile(PATTERNexp);
        Matcher matcher = pattern.matcher(text);

        System.out.println(matcher.find());

    }
}
