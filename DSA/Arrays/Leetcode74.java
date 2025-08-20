public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int start = 0;
        int end = rowLength*colLength-1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int value = matrix[mid / colLength][mid % colLength];

            if(value < target){
                start = mid + 1;
            }else if(value > target){
                end = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
