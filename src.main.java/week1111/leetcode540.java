package week1111;

import java.util.Stack;

//有序数组的单一元素 因为一定会是奇数 所有采用二分法
public class leetcode540 {
    // 二分法
    public int singleNonDuplicate(int[] nums) {
//        int length = nums.length;
//        if (length % 2 == 0) {
//            return -1;
//        }
//        int left = 0;
//        int right = length - 1;
//        while(length>1){
//            length=length/2;
//            if (nums[length] == nums[length - 1]){
//                left=length;
//                right=;
//            }
//        }
//        for (int i = 0; i < length; i++) {
//            length=length/2;
//
//        }
        return 0;
    }


    //使用栈
    public int singleNonDuplicateV2(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        if (nums.length==1){
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()){
                stack.push(nums[i]);
            }else{
                if (stack.peek()==nums[i]){
                    stack.pop();
                }else{
                    stack.push(nums[i]);
                }
            }
            if (stack.size()==2){
                break;
            }
        }
        return stack.get(0);
    }

    //使用异或运算符
    public int singleNonDuplicateV3(int[] nums) {
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode540 leetcode540 = new leetcode540();

        int[] nums={1,1,2,3,3,4,4,8,8};
        int i = leetcode540.singleNonDuplicateV3(nums);
        System.out.println(i);
        //异或表达式 1^1 = 0 , 0^0=0 ,1^0=1
        // 两个数 进行异或 就是 3 ^ 5   011 ^ 101   每一位进行异或运算 求出结果
        System.out.println(1^2);
    }
}
