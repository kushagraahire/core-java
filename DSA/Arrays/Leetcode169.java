public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            }else if(element == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return element;
    }
}
