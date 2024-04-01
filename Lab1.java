import java.util.ArrayList;
import java.util.Arrays;
import java.util.random.*;
import java.util.ArrayList.*;
public class Lab1 {
    /** Sorting algorithms **/

    public static void main(String[] args){
        int[] tmp = {2,1,5,17,3,7,4,99,323,5,214};
        insertionSort(tmp);
        System.out.println(Arrays.toString(tmp));

        int[] tmp2 = {2,1,5,17,3,7,4,99,323,5,214};
        quickSort(tmp2, 0, tmp2.length -1);
        System.out.println(Arrays.toString(tmp2));
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

    private static void quickSort(int[] array, int begin, int end){

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

        while(pointerLeft < pointerRight){      //Will increment/decrement the pointers as long as the pointers pointing at "sorted" elements.

            while(array[pointerLeft] < pivot && pointerLeft < pointerRight){ pointerLeft++; }
    
            while(array[pointerRight] > pivot && pointerLeft < pointerRight){ pointerRight--; }

            swap(array, pointerLeft, pointerRight);
            pointerLeft++;
            pointerRight--;
        }

        if(pointerLeft >= pointerRight){        //When the left pointer is larger than or equal to the right pointer
            swap(array, pointerRight, begin);   //we know that the pivot should be placed in that index.
        }

        return pointerRight;                    //Return the index of where the pivot element ended up.
    }

    // Mergesort.

    public static int[] mergeSort(int[] array) {
        throw new UnsupportedOperationException();
    }

    // Mergesort part of an array
    private static int[] mergeSort(int[] array, int begin, int end) {
        throw new UnsupportedOperationException();
    }

    // Merge two sorted arrays into one
    private static int[] merge(int[] left, int[] right) {
        throw new UnsupportedOperationException();
    }

    // Swap two elements in an array
    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }
}
