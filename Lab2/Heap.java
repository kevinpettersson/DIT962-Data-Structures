package Lab2;

public class Heap {

    public static void main(String[] args){
        System.out.println(5/2);

    }

    int[] heap;
    int size;
    int capacity;
    int[] sortedArray;

    //Constructor for creating heap-objects.
    public Heap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
        this.sortedArray = new int[capacity];
    }

    public int getRoot(){ return heap[0]; }

    public int getParent(int child){ return (child-1)/2; }   

    public int getLeftChild(int parent){ return 2 * parent + 1; }

    public int getRightChild(int parent){ return 2 * parent + 2; }

    

    //Method for swapping elements.
    public void swap(int parent, int child){

        int tmp      = heap[parent];
        heap[parent] = heap[child];
        heap[child]  = tmp;
    }

    //Method for inserting a new element into the heap.
    public void insert(int element){

        if (size == capacity){
            throw new IllegalArgumentException("Heap is full.");
        }

        heap[size] = element;
        int current = size;
        size++;

        while(heap[current] < heap[getParent(current)]){
            swap(current, getParent(current));
            current = getParent(current);
        }
    }



    //Heap-Sort algorithm.
    public void heapSort(int[] heap){

    }
    
}
