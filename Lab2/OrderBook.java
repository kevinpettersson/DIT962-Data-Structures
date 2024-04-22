package Lab2;

public class OrderBook {

    private Heap sellers;
    private Heap buyers;

    public OrderBook(){
        this.sellers = new Heap(10, false);
        this.buyers = new Heap(10, true);
    }

    public void addOrder(User user){
        if(user.getPrice() < 70){
            user.setPrice(70);
        }
        if (user.getIsBuyer()) {
            buyers.insert(user);
        } else {
            sellers.insert(user);
        }
    }

    //Decides which queue the user should be searched for.
    public void changeOrder(User user, int price){
        if(user.getIsBuyer()){
            change(user, buyers, price);

        } else if(!user.getIsBuyer()){
            change(user, sellers, price);
        } else {
            throw new IllegalAccessError("User hs no ongoing order");
        }
    }

    //Help function to changeOrder, handles the logic for actaully changing the new price.
    private void change(User user, Heap queue, int price){
        
        /*
        for(User u : queue){
            if(u.getName() == user.getName()){         ????     FIXA ITERATOR   ????
            u.setPrice(price);
        }
    }
         */
    }
    
    public void printOrders(){
        System.out.println("Order Book: ");

        System.out.print("Buyers: ");
        buyers.print();

        System.out.println("");

        System.out.print("Sellers: ");
        
        sellers.print();
    }
}
