import java.util.ArrayList;

public class MissingAndRepeating {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int repeating = -1;
        int missing = -1;

        for(int i = 0; i < arr.length; i++){
            int index = Math.abs(arr[i]) ;
            if(arr[index -1] < 0){
                repeating = index;
            }else{
                arr[index-1] = -arr[index-1];
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                missing = i+1;
                break;
            }
        }
        ans.add(repeating);
        ans.add(missing);
        return ans;
    }
}
