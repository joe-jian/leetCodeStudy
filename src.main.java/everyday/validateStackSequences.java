package everyday;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
* leetcode 946
* 验证栈序列
* 题目解析：
* 题目描述的是 两个传入的数组，判断第二个数组是否为第一个数组的栈序列，
* 即判断第二个数组是否为第一个数组的压栈序列。
* */
public class validateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped)
    {
        if (pushed.length == 0 || popped.length == 0 || pushed.length != popped.length){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int k : pushed) {
            set.add(k);
        }
        if (set.size() != pushed.length){
            throw new IllegalArgumentException("参数错误");
        }
        // 模拟压栈操作 碰到 popped[i]就出栈，否则就压栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0,j = 0; i < popped.length; i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
        validateStackSequences validateStackSequences = new validateStackSequences();
        boolean result = validateStackSequences.validateStackSequences(pushed, popped);
        System.out.println(result);
    }
}
