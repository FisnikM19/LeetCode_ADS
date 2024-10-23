package Reverse;

import java.util.Scanner;


public class Reverse {
    public static int reverse(int x) {
        int reverseNumber = 0;
        int temp = x;

        while(temp != 0) {
            int lastDigit = temp % 10;
            temp /= 10;

            if (reverseNumber > Integer.MAX_VALUE / 10 || (reverseNumber == Integer.MAX_VALUE / 10 && lastDigit > 7)) return 0;
            if (reverseNumber < Integer.MIN_VALUE / 10 || (reverseNumber == Integer.MIN_VALUE / 10 && lastDigit < -8)) return 0;
            // ms i kshirni kto if-at se nleet code jane kane kto constraints qe me return 0;

            reverseNumber = (reverseNumber * 10) + lastDigit;
        }

        return reverseNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int result = reverse(number);

        System.out.println(result);
    }
}
