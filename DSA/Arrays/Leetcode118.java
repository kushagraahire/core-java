import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        ans.add(firstList);
        if(numRows == 1){
            return ans;
        }
        for(int i = 1; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> prev = ans.get(ans.size() - 1);
            for(int j = 0; j < prev.size() - 1; j++){
                int n = prev.get(j) + prev.get(j+1);
                list.add(n);
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}
