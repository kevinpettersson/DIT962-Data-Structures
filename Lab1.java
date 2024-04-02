import java.util.ArrayList;
import java.util.Arrays;
import java.util.random.*;
import java.util.ArrayList.*;
public class Lab1 {
    /** Sorting algorithms **/

   public static void main(String[] args){
        System.out.println("Insertion sort nedan");
        int[] tmp = {2,1,5,17,3,7,4,99,323,5,214};
        insertionSort(tmp);
        System.out.println(Arrays.toString(tmp));

        System.out.println("Quick-sort nedan");
        int[] tmp2 = {2,1,5,17,3,7,4,99,323,5,214};
        int[] tmp4 = {0,2};
        quickSort(tmp4, 0, tmp4.length-1);
        System.out.println(Arrays.toString(tmp4));
        quickSort(tmp2, 0, tmp2.length -1);
        System.out.println(Arrays.toString(tmp2));
        System.out.println("Merge-sort nedan");
        int[] tmp3 = {2,1,5,17,3,7,4,99,323,5,214};
        mergeSort(tmp3);
        System.out.println(Arrays.toString(tmp3));
    }

    // Insertion sort.
    // We used in-place insertion sort, no swapping and no use of temporary arrays.

    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int tmp = array[i];
            int j = i-1;                        //represents index of the last element from the sorted portion of the array.

            while(j != -1 && tmp <= array[j]){  //We ensure loop loopin only when 'j' is within bounds of the array and tmp is smaller than array[j]
                array[j+1] = array[j];          //Shift element one step to the right aslong as tmp is smaller than array[j]
                j--;
            }
            array[j+1] = tmp;                   //j+1 beacuse j was decremented before exiting the loop. placing tmp at correct position.
        }
    }

    // Quick sort.

    public static void quickSort(int[] array, int begin, int end){
        
        if(begin >= end){                          //When the array is sorted the subarray will only have 1 element and we imeditely return the method. 

            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);          // Recursive calls to sort the subarrays, with the right indices.
        quickSort(array, pivot+1, end);
    }

    private static int partition(int[] array, int begin, int end) {

        int pivot = array[begin];
        int pointerLeft = begin+1;
        int pointerRight = end;

        while(pointerLeft <= pointerRight){      //Will increment/decrement the pointers as long as the pointers pointing at "sorted" elements.

            while(pointerLeft <= pointerRight && array[pointerLeft] <= pivot) { pointerLeft++; }
    
            while(pointerLeft <= pointerRight && array[pointerRight] >= pivot) { pointerRight--; }

            if(pointerLeft < pointerRight){
                swap(array, pointerLeft, pointerRight);
            }
        }
                                                
        swap(array, pointerRight, begin);       //Always swap the right pointer with the pivot.
        
        return pointerRight;                    //Return the index of where the pivot element ended up.
    }

    // Mergesort.

    public static void mergeSort(int[] array) {
        int length = array.length;

        if(length < 2){       
            return;
        }

        int mid = length / 2;
        int[] leftArr  = new int[mid];
        int[] rightArr = new int[length - mid]; //(length - mid) For correct splittning of the subarrays taking care of uneven array lengths.

        for (int i = 0; i < mid; i++) {         //Copying elements for each side of the split.
            leftArr[i] = array[i];
        }
        for (int i = mid; i < length; i++) {
            rightArr[i - mid] = array[i];       //(i - mid) Setting the element at the correct indices and not what mid represent.
        }

        mergeSort(leftArr);                     //Recursive calls for each splitted array.
        mergeSort(rightArr);
        merge(array, leftArr, rightArr);
    }

    // Mergesort part of an array
    private static void merge(int[] array, int[] leftArr, int[] rightArr) {
        int left = leftArr.length;
        int right = rightArr.length;

        int i = 0, j = 0, k = 0;            //The pointers for each array, our left, right and merged array.
                                            //k = merged, i = left, j = right.

        while(i < left && j < right){      

            if(leftArr[i] <= rightArr[j]){
                array[k] = leftArr[i];
                i++;
            } else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < left){                   // In case the while loop misses an index we directly copy it to the sorted array in correct index.
            array[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < right){
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }
}
