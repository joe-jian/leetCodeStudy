package week1111;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * leetcode 20 有效的括号数
 * 思路：统计左括号，右括号，如果右括号数量大于左括号，直接返回false，如果左括号数量大于右括号，直接返回false，
 * 如果左右括号数量相等，判断是否成对出现，如果成对出现，且 左括号的下摆 返回true，否则返回false
 */
public class leetcode20 {
    public boolean isValid(String s) {
        String all = "aabbccddeeff"; // 示例输入
        // 使用 IntStream 获取每个字符及其索引
        Map<Character, List<Integer>> collect = IntStream.range(0, all.length())
                .boxed()
                .collect(Collectors.groupingBy(
                        all::charAt, // 分组键为字符
                        Collectors.mapping(i -> i, Collectors.toList()) // 值为索引列表
                ));
//       List<Character> all=new ArrayList<>();
//       for (char c:s.toCharArray())
//           all.add(c);
//        Map<Character, List<Character>> collect = all.stream().collect(Collectors.groupingBy(a -> a));
        return true;
    }

    public boolean isValidV2(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && (!stack.isEmpty() && stack.peek() == '(')) {
                stack.pop();
            } else if (c == '}' && (!stack.isEmpty() && stack.peek() == '{')) {
                stack.pop();
            } else if (c == ']' && (!stack.isEmpty() && stack.peek() == '[')) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        leetcode20 leetcode20 = new leetcode20();
        String s = "()[]{}";
        boolean valid = leetcode20.isValidV2(s);
        System.out.println(valid);
        s="({)}";
        valid = leetcode20.isValidV2(s);
        System.out.println(valid);
    }
}



