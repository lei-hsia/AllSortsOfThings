package ap.chapter8;

/**
 * @author lei
 * @date 01/15/2022 10:22 AM
 */

import com.sun.tools.javac.util.StringUtils;

import java.util.Scanner;
public class Palindromes {

    public static boolean isPal(String str) {
        String s = str.replaceAll("\\s", "");
        if(s.length() == 0 || s.length() == 1)
            return true;

        if(s.toLowerCase().charAt(0) == s.toLowerCase().charAt(s.length()-1))
            return isPal(s.substring(1, s.length()-1));
        return false;
    }

    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("type a word to check if its a palindrome or not");
        String x = sc.nextLine();
        if(isPal(x))
            System.out.println(x + " is a palindrome");
        else
            System.out.println(x + " is not a palindrome");
    }
}
