package code.input;

import java.util.*;

public class InutExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入整数
//        textNumber(in);
        // 输入字符串
//        textString(in);
    }

    private static void textString(Scanner in) {
        String s = "";
        while (in.hasNext()) {
            s = in.next();
            System.out.println("s = " + s);
        }
    }

    private static void textNumber(Scanner in) {
        int a = 0, b = 0, sum = 0;
        while (in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.println("a = " + a + " b = " + b + " sum = " + (a + b));
        }
    }
}
