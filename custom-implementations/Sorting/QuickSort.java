package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 8 ,3, 9, 4, 5, 7};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low >= high) return;
        int left = low;
        int right = high;
        int pivot = arr[high];

        while(left < right){
            while(left < right && arr[left] <= pivot){
                left++;
            }
            while(left < right && arr[right] >= pivot){
                right--;
            }
            swap(arr, left, right);
        }
        swap(arr, left, high);
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }
}
