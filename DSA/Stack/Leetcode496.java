public class Leetcode496 {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int[] idxArr = new int[11110];
            for(int i = 0; i < m; i++){
                idxArr[nums2[i]] = i;
            }
            for(int i = 0; i < n; i++){
                nums1[i] = greater(nums2, idxArr[nums1[i]]);
            }
            return nums1;
        }
        public int greater(int[] nums2, int idx){
            for(int i = idx; i < nums2.length; i++){
                if(nums2[i] > nums2[idx]){
                    return nums2[i];
                }
            }
            return -1;
        }
    }
}
