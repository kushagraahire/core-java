public class Leetcode242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            int ch1 = (int) s.charAt(i) - 'a';
            int ch2 = (int) t.charAt(i) - 'a';

            arr[ch1]++;
            arr[ch2]--;
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}
