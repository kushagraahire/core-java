import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            nums.add(nums1[i]);
        }

        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(nums.contains(nums2[i])) {
                answer.add(nums2[i]);
                nums.remove(nums2[i]);
            }
        }

        int[] ans = new int[answer.size()];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
