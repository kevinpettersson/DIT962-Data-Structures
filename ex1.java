import java.util.ArrayList;
import java.util.List;

public class ex1 {

    // Creates an new array with doubled length.

    public static int[] dynamicArray(int[] arr){
        int update = arr.length * 2;
        int[] newArr = new int[update];
        
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // Binary search, return index of target.

    public static int binarySearch(List<Integer> list, int target, int start, int end){

        if(start <= end) {
            int middle = (start + end) / 2;

            if(list.get(middle) == target){
                return middle;
            }
            if(list.get(middle) > target){
    
                return binarySearch(list, target, start, middle - 1);
            }
            else return binarySearch(list, target, middle +1 , end);
        }
        return -1;
    }

    // Reverse an array

    public static void reverse(ArrayList<Integer> list){
        int size = list.size();

        for (int i = 0, j = size - 1; i < size / 2; i++, j--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);    
        }
    }

    public static void main(String[] args){

        // Create dynamic array \\

        int[] arr = {1,2,3,4,5};
        int[] arr2 = dynamicArray(arr);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        // Reverse an array \\

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        reverse(list);
        System.out.println("");
        System.out.println(list.toString());

        // Binary search \\

        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        tmp.add(5);
        tmp.add(6);
        System.out.println(binarySearch(tmp, 6, 0, 5));
    }
}
