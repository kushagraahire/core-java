public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;

        for(int num : nums){
            if(num != 0){
                nums[idx] = num;
                idx++;
            }
        }

        while(idx < n){
            nums[idx] = 0;
            idx++;
        }
    }
}
