package me.fengqijun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Main.myAtoi(""));
        System.out.println(Main.myAtoi("42"));
        System.out.println(Main.myAtoi("-42"));
        System.out.println(Main.myAtoi("    -42"));
        System.out.println(Main.myAtoi("4193 with words"));
        System.out.println(Main.myAtoi("words and 987"));
        System.out.println(Main.myAtoi("-91283472332"));
    }

    public static int myAtoi(String s) {
        StringBuilder sb = new StringBuilder(s);

        // delete leading whitespace;
        while(sb.length() > 0 && sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0) {
            return 0;
        }

        // is negative or not
        boolean isNegative = false;
        char flag = sb.charAt(0);
        if (flag == '-') {
            isNegative = true;
            sb.deleteCharAt(0);
        }
        if (flag == '+') {
            sb.deleteCharAt(0);
        }

        StringBuilder digitsString = new StringBuilder();
        List<String> digits = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

        // read in next until the next non-digit character or at the end of the input
        for(int i=0; i < sb.length(); i++) {
            if (digits.contains(String.valueOf(sb.charAt(i)))){
                digitsString.append(String.valueOf(sb.charAt(i)));
            } else {
                break;
            }
        }

        // delete leading 0,
        while (digitsString.length() > 0 && digitsString.charAt(0) == '0') {
            digitsString.deleteCharAt(0);
        }

        String minString = "2147483648";
        String maxString = "2147483647";

        String clampString = isNegative ? minString : maxString;

        // longer string
        if (digitsString.length() > clampString.length()) {
            digitsString = new StringBuilder(clampString);
        } else if (digitsString.length() == clampString.length() && digitsString.toString().compareTo(clampString) > 0) {
            digitsString = new StringBuilder(clampString);
        }

        if (digitsString.length() == 0) {
            return 0;
        } else {

            int result = 0;

            while(digitsString.length() >= 1) {

                int pow = 1;
                int currentLength = digitsString.length();
                while(currentLength > 1) {
                    pow = pow * 10;
                    currentLength--;
                }

                result += Integer.parseInt(String.valueOf(digitsString.charAt(0))) * pow;
                digitsString.deleteCharAt(0);

            }

            return result * (isNegative ? -1 : 1);
        }

    }
}
