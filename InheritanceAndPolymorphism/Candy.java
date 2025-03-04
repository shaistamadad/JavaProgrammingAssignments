public class Candy extends DessertItem {
	private double weight;
	private int pricePerPound;		// in cents
	private int cost;
	
	public Candy(String name, double weight, int pricePerPound) {
		super(name);
		this.pricePerPound = pricePerPound;
		this.weight = weight;
	}
	
	public int getCost() {
		this.cost = (int)Math.round(this.weight * this.pricePerPound);
		return cost;
	}
	
	public int getPricePerPound() {
		return pricePerPound;
	}
	
	public double getWeight() {
		return weight;
	}
}