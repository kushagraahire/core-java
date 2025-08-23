import java.util.ArrayList;
import java.util.List;

public class Leetcode229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList();
        int n = nums.length;
        int count1 = 0;
        int element1 = 0;
        int count2 = 0;
        int element2 = 0;

        for(int num : nums){
            if(num == element1){
                count1++;
            }else if(num == element2){
                count2++;
            }else if(count1 == 0){
                count1++;
                element1 = num;
            }else if(count2 == 0){
                count2++;
                element2 = num;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(num == element1){
                count1++;
            }else if(num == element2){
                count2++;
            }
        }
        if(count1 > n/3){
            ans.add(element1);
        }
        if(count2 > n/3){
            ans.add(element2);
        }
        return ans;
    }
}
