import java.util.Scanner;

public class CountingInversions {
	public static long noOfInversions;
	
    public static long countInversions(int[] arr){
    	int[] tempArr = new int[arr.length];
        noOfInversions = 0;
    	mergeSort(arr, tempArr, 0, arr.length - 1);
        return noOfInversions;
    }
    
    private static void mergeSort(int[] arr, int[] tempArr, int low, int high) {
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(arr, tempArr, low, mid);
            mergeSort(arr, tempArr, mid + 1, high);
            noOfInversions += merge(arr, tempArr, low, mid, high);
        }
    }
    
    private static long merge(int[] arr, int[] tempArr,int low, int mid, int high) {
        int firstHalfIndex = low;
        int secondHalfIndex = mid+1;
        int k = firstHalfIndex;
        long totalNoOfInversions = 0;
        int secondHalfIncrement = 0;
        while(firstHalfIndex <= mid) {
            if(secondHalfIndex <= high) {
                if(arr[firstHalfIndex] > arr[secondHalfIndex]) {
                    totalNoOfInversions += (secondHalfIndex - firstHalfIndex- secondHalfIncrement);
                    tempArr[k++] = arr[secondHalfIndex++];
                    secondHalfIncrement++;
                } else {
                    tempArr[k++] = arr[firstHalfIndex++];
                }
            } else {
                tempArr[k++] = arr[firstHalfIndex++];
            }
        }
        while(secondHalfIndex <= high) {
            tempArr[k++] = arr[secondHalfIndex++];
        }
        for(int i = 0; i <= high - low; i++) {
            arr[i+low] = tempArr[i+low];
        }
        return totalNoOfInversions;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }
    
    
}
