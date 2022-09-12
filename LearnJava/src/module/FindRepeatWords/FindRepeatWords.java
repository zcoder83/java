package module.FindRepeatWords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());

        // regular expression
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";


        while(num-- > 0) {
            String str = input.nextLine();

            Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(str);
            while (m.find()) {
                str = str.replaceAll(m.group(), m.group(1));
            }
            System.out.println(str);
        }
    }
}
