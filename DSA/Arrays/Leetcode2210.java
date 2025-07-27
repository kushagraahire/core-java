public class Leetcode2210 {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int prev = -1;
        int next = -1;
        int curr = -1;
        int count = 0;

        for(int i = 0; i < n-1; i++){
            curr = nums[i];
            if(nums[i] == nums[i+1]){
                continue;
            }
            next = nums[i+1];
            if(prev != -1 && ((curr < prev && curr < next) || (curr > prev && curr > next))){
                count++;
            }
            prev = curr;
        }
        return count;
    }
}
