package Palindrome;

import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        int reverseNumber = 0;
        int temp = x;

        while(temp > 0) {
            int lastDigit = temp % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            temp /= 10;
        }

        if (x == reverseNumber) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (isPalindrome(number)) {
            System.out.println("This number: " + number + " is a palindrome");
        } else {
            System.out.println("This number " + number + " is not a palindrome");
        }
    }
}
