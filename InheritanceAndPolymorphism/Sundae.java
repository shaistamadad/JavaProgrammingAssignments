public class Sundae extends IceCream {
	private String toppingName;
	private int toppingPrice;		// in cents
	private int cost;
	
	public Sundae(String iceCreamName, int iceCreamCost, String toppingName, int toppingPrice) {
		super(iceCreamName, iceCreamCost);
		this.toppingName = toppingName;
		this.toppingPrice = toppingPrice;		
	}
	
	public int getCost() {
		cost = this.toppingPrice + super.getCost();
		return cost;
	}
	
	public String getTopping() {
		return toppingName;
	}
	

}