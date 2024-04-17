package Lab2;

import java.util.Arrays;

public class OrderBook {

    private Heap sellers;
    private Heap buyers;

    public OrderBook(){
        this.sellers = new Heap(10, false);
        this.buyers = new Heap(10, true);
    }

    public void addOrder(User user){
        if(user.getIsBuyer()){
            buyers.insert(user);
        } else {
            sellers.insert(user);
        }
    }

    public void changeOrder(User user){

    }

    public void printOrders(){

        System.out.println("Buyers left: ");
        buyers.print();

        System.out.println("Sellers left: ");
        sellers.print();
    }
}
