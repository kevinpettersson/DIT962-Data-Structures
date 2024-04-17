package Lab2;

public class User {


    private String name;
    private int price;
    private boolean isBuyer;

    public User(String name, int price, boolean isBuyer){
        this.name = name;
        this.price = price;
        this.isBuyer = isBuyer;
    }

    public void createBid(User bidder){

        if(isBuyer){
            placeBuyBid();
        } else {
            placeSellbid();
        }
    }

    private void placeBuyBid(){

    }

    private void placeSellbid(){

    }

    // GETTERS \\
    
    public String getName(){ return this.name; }

    public int getPrice(){ return this.price; }

    public boolean getIsBuyer(){ return this.isBuyer;}
    
    
}
