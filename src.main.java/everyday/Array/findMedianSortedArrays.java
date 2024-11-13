package everyday.Array;
/**
* leetcode 4
 * 题目解析，传入两个有序数组，返回两个数组的中位数，如果两个数组的长度之和为奇数，返回中位数，如果为偶数，返回中位数的平均值
* */


public class findMedianSortedArrays {
    public static void main(String[] args)
    {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        boolean flag;
        //如果是偶数，则中位数为两个数组的中位数，否则为两个数组的中位数的平均值
        if (total % 2 == 0) {
            total=total/2+1;
            flag = true;
        } else {
            total=total/2+1;
            flag = false;
        }
        int[] nums3 = new int[total];
        int i = 0, j = 0, k = 0;
        //首先找到的中间 k是num3的下标，total是数组的长度 循环条件是i<m && j<n
        while (k<total){
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    nums3[k++] = nums1[i++];
                } else {
                    nums3[k++] = nums2[j++];
                }
            } else if (i < m) {
                nums3[k++] = nums1[i++];
            } else if (j < n) {
                nums3[k++] = nums2[j++];
            }
        }
        if (!flag){
            return nums3[total-1];
        }else{
            return (nums3[total-2]+nums3[total-1])/2.0;
        }

    }

    /**
    * 最简单的方法就是拼接后进行排序，然后找到中位数，但是时间复杂度为O(nlogn)
     * 刚好复习一下冒泡排序
    * */
   public static double findMedianSortedArraysV2(int[] nums1, int[] nums2)
    {
        int[] ints = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, ints, 0, nums1.length);
        System.arraycopy(nums2, 0, ints, nums1.length, nums2.length);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        if (ints.length % 2 == 0) {
            return (ints[ints.length / 2] + ints[ints.length / 2 - 1]) / 2.0;
        }
        return ints[ints.length / 2];


    }
}
