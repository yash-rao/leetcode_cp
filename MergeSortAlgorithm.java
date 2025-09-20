// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    
    public static int[] merge(int[] left,int[] right) {
        int i=0,j=0,k=0;
        int n=left.length;
        int m=right.length;
        int new_arr[] = new int[n+m];
        while(i<n && j<m){
            if(left[i]<=right[j]){
                new_arr[k]=left[i];
                i++;
            }
            else if(left[i]>right[j]){
                new_arr[k]=right[j];
                j++;
            }
            k++;
        }
        while(i<n){
            new_arr[k]=left[i];
            i++;
            k++;
        }
        while(j<m){
            new_arr[k]=right[j];
            j++;
            k++;
        }
        return new_arr;
    }
    
    public static int[] mergeSort(int[] arr, int low, int high) {
        if(low==high) {
            return new int[]{arr[low]};
        }
        
        int mid = (low+high)/2;
        int arr_left[] = mergeSort(arr,low,mid);
        int arr_right[] = mergeSort(arr,mid+1,high);
        int final_arr[] = merge(arr_left,arr_right);
        return final_arr;
        
        
    }
    
    public static void main(String[] args) {
        int[] arr = {1,5,4,6,7,2,10};
        int n = arr.length-1;
        
        int merged_arr[]=mergeSort(arr,0,n);
        
        for(int i=0;i<=n;i++) {
            System.out.println(merged_arr[i]+" "+i);
        }
    }
}
