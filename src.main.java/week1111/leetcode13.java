package week1111;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * leetcode13 罗马数字转整数
 *
 * @author: jyj
 * @create: 2024年11月13日 14:08:06
 * 目的是 传入一个罗马数字转为数字 包含顺序的问题 因为 IV表示的是5-1，但是I在V前面，所以是4，所以需要判断一下 而且只能
 */

public class leetcode13 {
    public int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        // 获取第一个 值

        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = map.get(s.charAt(i));
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }

        return result;
    }
    public int romanToIntV2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        leetcode13 leetcode13 = new leetcode13();
        String s = "MCMXCIV";
        int i = leetcode13.romanToInt(s);
        System.out.println(i);
    }
}
