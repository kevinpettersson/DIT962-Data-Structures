import java.util.ArrayList;

public class ex1 {


    public static int binarySearch(ArrayList<Integer> list, int target, int start, int end){

        int middle = Math.round(start + end / 2);

        if(list.get(start) > list.get(end)){
            return -1;
        }
        if(list.get(middle) == target){
            return middle;
        }
        if(list.get(middle) > target){
            list = (ArrayList<Integer>) list.subList(middle-1, list.size() -1);
            return binarySearch(list, target, middle-1, end);
        }
        if(list.get(middle) < target){
            list = (ArrayList<Integer>) list.subList(0, middle+1);
            return binarySearch(list, target, start, middle+1);
        }
        return -1;

    }


    public static void reverse(ArrayList<Integer> list){
        int size = list.size();

        for (int i = 0, j = size - 1; i < size / 2; i++, j--) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);    
        }
    }


    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> tmp = list;

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        reverse(list);

        System.out.println(list.toString());

        System.out.println(binarySearch(tmp, 4, 0, 5));
    }
}
