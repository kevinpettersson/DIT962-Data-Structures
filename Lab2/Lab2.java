package Lab2;

public class Lab2{

    public static void main(String[] args){
        
        OrderBook orderBook = new OrderBook();

        User user1 = new User("Kevin", 75, true);
        User user2 = new User("Alice", 75, false);
        User user3 = new User("Otto", 70, true );
        User user4 = new User("Alex", 74, false );

        orderBook.addOrder(user1);
        orderBook.addOrder(user2);
        orderBook.addOrder(user3);
        orderBook.addOrder(user4);

        orderBook.printOrders();
    }
}
    
