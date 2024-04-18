package Lab2;

public class Heap {

    private User[] heap;
    private int size;
    private int capacity;
    private boolean isBuyer;

    //Constructor for creating heap-objects.
    public Heap(int capacity, boolean isBuyer){
        this.capacity = capacity;                   //The intital capacity of the heap.
        this.heap = new User[capacity];             //Create a new array of length capacity.
        this.size = 0;                              //Heap starts with 0 elements.
        this.isBuyer = isBuyer;                     //Decides if the heap is a min or max heap.          
    }

    //Method for inserting a new object into the heap.
    //Depending on the type of bid we insert element differently.
    public void insert(User user){
        if (this.size == this.capacity){
            throw new IllegalArgumentException("Heap is full.");
        }
        if(isBuyer){
            maxInsert(user);
        } else {
            minInsert(user);
        }
    }

    //If its a sell bid we call the minInsert method to place the element correct in the tree
    private void minInsert(User user){
        heap[size] = user;
        int current = size;
        size++;

        while(heap[current].getPrice() < heap[getParent(current)].getPrice()){
            swap(current, getParent(current));
        }

    }
    //If its a buy bid we call the maxInsert method to place the element correct in the tree.
    private void maxInsert(User user){
        heap[size] = user;
        int current = size;
        size++;

        while(heap[current].getPrice() > heap[getParent(current)].getPrice()){
            swap(current, getParent(current));
        }
    }

    //Method for swapping elements.
    public void swap(int parent, int child){
        User tmp     = heap[parent];
        heap[parent] = heap[child];
        heap[child]  = tmp;
    }

    public void print(){

        for (int i = 0; i < heap.length; i++) {
            if(heap[i] != null){
                System.out.print(heap[i].getName() + " " + heap[i].getPrice() + ", ");
            }
        }
    }

    // GETTERS \\

    public User getRoot(){ return heap[0]; }

    public int getParent(int child){ return (child-1)/2; }   

    public int getLeftChild(int parent){ return 2 * parent + 1; }

    public int getRightChild(int parent){ return 2 * parent + 2; }

    public int getSize(){ return this.size; }
    
    public int getCapacity(){ return this.capacity;}

}
