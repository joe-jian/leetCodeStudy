package everyday;

import java.util.ArrayList;
import java.util.List;

public class ValidBinaryStrings {

    public static List<String> generateValidBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        generateStrings(n, "", result);
        return result;
    }

    private static void generateStrings(int n, String prefix, List<String> result) {
        if (n == 0) {
            if (isValid(prefix)) {
                result.add(prefix);
            }
            return;
        }
        generateStrings(n - 1, prefix + "0", result);
        generateStrings(n - 1, prefix + "1", result);
    }

    private static boolean isValid(String s) {
        for (int i = 0; i + 1 < s.length(); i++) {
            if (s.substring(i, i + 2).equals("00")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int n = 4;
//        List<String> validStrings = generateValidBinaryStrings(n);
//        System.out.println(validStrings);
        String s = Integer.toBinaryString(4);
        System.out.println(s);
        System.out.println(4 << 3); // 4 << 3 = 4 * 2^3 = 4 * 8 = 32
        System.out.println(10 ^ 2); //10 的二进制表示是 1010。
//        2 的二进制表示是 0010。
//        按位异或运算的结果是 1000，对应的十进制值是 8。
    }
}