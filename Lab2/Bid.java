package Lab2;
public class Bid {
	final private String name;
	final private int bid;

	public Bid(String name, int bid) {
		this.name = name;
		this.bid = bid;
	}

	public String getName(){
		return this.name;
	}

	public int getPrice(){
		return this.bid;
	}

	public int hashCode() {
		return 1 + 23*bid + 31*name.hashCode();
	}

	public boolean equals(Object obj){
		if (obj == null || !(obj instanceof Bid)) return false;

		Bid bidd = (Bid) obj;

		return (this.getName().equals(bidd.getName()) && this.getPrice() == bidd.getPrice());
	}
	
	public String toString(){
		
		return getName() + " " + getPrice();
	}
}

