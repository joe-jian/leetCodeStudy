package everyday;


import java.util.Arrays;

//排序的方法
public class SortNum {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10,3};
//        maoPaoSort(nums);
        separateTwo(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void maoPaoSort(int[] nums){
        if (nums.length == 0){
            throw new RuntimeException("数组为空");
        }
        int k=nums.length;
        while (k>0){
            for (int i = 0; i < k-1; i++) {
                if (nums[i]<nums[i+1]){
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                }
            }
            k--;
        }

    }

    public static void quickSort(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
    }
    public static void separateTwo(int[] citations){
        if (citations == null || citations.length <= 1) {
            return;
        }

        int n = citations.length;
        for (int i = 1; i < n; i++) {
            int key = citations[i];
            int insertPos = binarySearch(citations, key, 0, i - 1);

            // 将 [insertPos, i-1] 区间的元素向右移动一位
            System.arraycopy(citations, insertPos, citations, insertPos + 1, i - insertPos);

            // 插入 key
            citations[insertPos] = key;
        }
    }

    // 二分查找确定插入位置
    private static int binarySearch(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void separateTwo2(int[] citations){
        if (citations == null || citations.length <= 1){
            return;
        }
        int n = citations.length;
    }


}
