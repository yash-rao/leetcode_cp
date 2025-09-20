import java.util.*;
class Main {
    public static void main(String[] args) {
        int[] arr = {12,34,45,56,67,78,89,90};    

        System.out.println("Enter number to search ");
        Scanner sc = new Scanner(System.in);
        int element = sc.nextInt();
        int result = 0;

        int low = 0,high = arr.length-1,mid=0;
        while(low<=high) {
            float m = (low+high)/2;  
            mid = (int)Math.floor(m);
            if(arr[mid]==element) {  
                result = mid;
                break;
            }
            else if(arr[mid]>element) {
                high = mid - 1;
            }
            else if(arr[mid]<element){
                low = mid + 1;
            }
        }
        if(arr[mid]==element) {
        System.out.println(mid+1);
        }
        else{
            System.out.println("Number not found");
        }
    }
}
