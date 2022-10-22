package DividenConquer;

public class MergeSort {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        // Base case
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); // for left part
        mergeSort(arr, mid + 1, ei); // for rigght part
        merge(arr, si, mid, ei); // for merge sorted left and right part
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        // left(0,3)=4, right(4,6)=3, 6-0+1=7 because i need total 7 index
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for 1st sorted part
        int j = mid + 1; // iterator for 2nd sorted part
        int k = 0; // iterator for temp arr

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // for leftover elements of 1st sorted part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // for leftover elements of 2nd sorted part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original arr
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
        /*
         * Time complexity = O(nlogn).
         * Space complexity = O(n).
         */
    }
}
