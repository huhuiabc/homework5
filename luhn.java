import java.util.ArrayList;
import java.util.List;

public class luhn {

    public static void main(String[] args) {
        String str="7992739871";
        System.out.println(str);

        if (check(str)){
            System.out.println("校验成功");
        }else {
            System.out.println("校验失败");
        }
    }

    public static String addCheck(String digits){
        return digits+getCheck(digits);
    }

    private static boolean check(String digits) {
        return check(numStringToArray(digits));
    }

    private static int getCheck(String digits) {
        return getCheck(numStringToArray(digits));
    }

    private static Integer[] numStringToArray(String numStr){
        byte[] bytes=numStr.getBytes();
        List<Integer> list=new ArrayList<>();
        for (byte b:bytes){
            list.add((int) b-48);
        }
        Integer[] digits=new Integer[list.size()];
        list.toArray(digits);
        return digits;
    }

    private static boolean check(Integer[] digits) {
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {

            int digit = digits[length - i - 1];

            if (i % 2 == 1) {
                digit *= 2;
            }
            sum += digit > 9 ? digit - 9 : digit;
        }
        return sum % 10 == 0;
    }

    private static int getCheck(Integer[] digits) {
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            int digit = digits[length - i - 1];
            if (i % 2 == 0) {
                digit *= 2;
            }
            sum += digit > 9 ? digit - 9 : digit;
        }
        return sum * 9 % 10;
    }
}