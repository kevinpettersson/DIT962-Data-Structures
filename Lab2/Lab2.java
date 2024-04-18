package Lab2;

public class Lab2{

    public static void main(String[] args){
        
        OrderBook orderBook = new OrderBook();
        User user1 = new User("Kevin", 70, true);
        orderBook.addOrder(user1);
        User user2 = new User("Alice", 65, true );
        orderBook.addOrder(user2);
        orderBook.printOrders();



    }
}
    
