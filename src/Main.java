
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//      String Joiner Example
        StringJoiner sj = new StringJoiner("} {","{","}");
        sj.add("Value1").add("Value2").toString();
        System.out.println(sj);

//        using reg ex to split the string
        String s1 = "apple apple and chapple please";
        System.out.println(s1);
        String [] s2= s1.split("\\b");
        for(String s:s2) {
            if(s.matches("\\w+")) {
                System.out.println(s);
            }
        }

//        using pattern class for the same
        Pattern pattern = Pattern.compile("app+");
        Matcher matcher = pattern.matcher(s1);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

};