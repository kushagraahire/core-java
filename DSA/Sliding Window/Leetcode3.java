public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int left = 0;
        int ans = 1;
        int n = s.length();
        map[s.charAt(left)] = 1;
        for(int right = left + 1; right < n; right++){
            int ch = s.charAt(right);

            if(map[ch] != 0){
                while(s.charAt(left) != ch){
                    map[s.charAt(left)] = 0;
                    left++;
                }
                left++;
                map[ch] = 1;
            }else{
                int length = right - left + 1;
                ans = Math.max(ans, length);
                map[ch] = 1;
            }
        }
        return ans;
    }
}
