public class QuickSort { // this is partition based sort algorithm
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low < high){
            int p = partition(arr, low, high);
            quickSort(arr, low, p-1);
            quickSort(arr, p+1, high);
        }
    }
    static int partition(int arr[], int low, int high) // implement partition
    {
        int pivot = arr[low];
        int l = low+1;
        int r = high;
        while(l <= r){
            while(l <= high && arr[l] <= pivot) l++;
            while(r >= low && arr[r] > pivot) r--;
            if(l < r){ // swap
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        int temp = arr[r]; // swap the pivot element to the middle where left side is less than the pivot and right is greater than it
        arr[r] = pivot;
        arr[low] = temp;
        return r; // the right position of partition element index
    }
}
