// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    
    public static int binarySearch(int[] arr, int low, int high, int element){
        float m = (low + high)/2;
        int mid = (int)Math.floor(m);
        if (arr[mid]==element || low>high) {
            return mid;
        }
        else if(arr[mid]>element) {
            high = mid-1;
            return binarySearch(arr,low,high,element);
        }
        else if(arr[mid]<element) {
            low = mid+1;
            return binarySearch(arr,low,high,element);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {12,34,45,56,67,78,89,90};
        int element = 10;
        int result = binarySearch(arr, 0, arr.length-1, element);
        if(arr[result]==element){
            System.out.println(result+1);
        }
        else {
            System.out.println("No matches :( ");
        }
    }
}
