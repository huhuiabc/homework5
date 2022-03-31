package first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Luhn {	
	//Luhn算法,银行卡校验算法。	
    public static void main(String[] args) {    	
        System.out.println("请输入需要校验的银行卡号：");
        Scanner sc =new Scanner(System.in);
    	String str=sc.next();
    	String strValue=Luhn.addCheck(str);      
 
        if (check(strValue)){
            System.out.println("校验成功");
        }else {
            System.out.println("校验失败");
        }
    }
 
    //数字字符串添加校验位,digits 不带校验位的数字字符串,return 添加校验位的字符串
    public static String addCheck(String digits){
        return digits+getCheck(digits);
    }
 
    //检查带校验位的字符串,digits 带校验位的字符串,return 检查结果
    private static boolean check(String digits) {
        return check(numStringToArray(digits));
    }
 
    //获取校验位,digits 不带校验位的字符串,return 校验位
    private static int getCheck(String digits) {
        return getCheck(numStringToArray(digits));
    }
 
    //辅助函数 
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

