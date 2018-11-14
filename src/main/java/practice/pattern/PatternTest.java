package practice.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaiscript on 2017/4/11.
 */
public class PatternTest {

    public static void main(String[] args) {
        String cs = "(\\w+\\d*)(@yy.com)";
        String str = "chenkai1@yy.com,zhoujianxing@yy.com";

        String cs1 = "(http://|https://)(w{3})\\.\\w*(\\.com)";
        String str1 = "http://www.google.com";

        String cs2 = "";
        String str2 = "chenkai1@yy.com\n";

        Pattern p = Pattern.compile(cs1);
        Matcher matcher = p.matcher(str1);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }

}
