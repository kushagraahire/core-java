public class Leetcode75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        int index = 0;

        while(index <= right){
            if(nums[index] == 0){
                swap(index, left, nums);
                left++;
                index++;
            }else if(nums[index] == 2){
                swap(index, right, nums);
                right--;
            }else if(nums[index] == 1){
                index++;
            }

        }
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
