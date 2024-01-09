import java.util.*;
class Solution {
    public boolean check(int[] nums) {
        int moved = movedNums(nums);
        if (moved == -1){
            return true;
        } else {
            int n = nums.length;
            int[] ref = Arrays.copyOf(nums,n);
            for(int i = 0;i<n;i++){
                nums[i] = ref[(i+moved)%n];
            }
            return movedNums(nums) == -1;
        }
    }
    public int movedNums(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            if (nums[i]>nums[i+1]){
                return i+1;
            }
        }
        return -1;
    }
}