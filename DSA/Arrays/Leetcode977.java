public class Leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n-1;
        int idx = n-1;
        while(left <= right){
            int leftNum = Math.abs(nums[left]);
            int rightNum = Math.abs(nums[right]);
            if(leftNum > rightNum){
                ans[idx] = leftNum * leftNum;
                left++;
            }else{
                ans[idx] = rightNum * rightNum;
                right--;
            }
            idx--;
        }
        return ans;
    }
}
