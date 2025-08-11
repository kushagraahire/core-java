import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return intervals;

        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0],a2[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i = 1; i < n; i++){
            if(list.get(list.size()-1)[1] >= intervals[i][0]){
                list.get(list.size()-1)[1] = Math.max(intervals[i][1], list.get(list.size()-1)[1]);
            }else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[0][]);
    }
}
