package module.FindRepeatWords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        // regular expression
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+"; // b: word boundary, w: word, +: one or more, 1: match the result of group 1, which is (\w+)


        while(num-- > 0) {
            String str = input.nextLine();

            Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(str); // try to match input string by regex with no case-sensitive.
            while (m.find()) {
                // replace matching group with first matching one.
                str = str.replaceAll(m.group(), m.group(1));
            }
            System.out.println(str);
        }
    }
}
