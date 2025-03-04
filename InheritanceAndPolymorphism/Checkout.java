public class Checkout {
	 DessertItem[] myDessertItems;  //initialize the array 
	 int numberOfItems;
	 final int RECEIPT_WIDTH = 30;
	
	public Checkout() {
		myDessertItems = new DessertItem[100];
	}
	
	public int numberOfItems() {
		return numberOfItems;
	}
	
	public void enterItem(DessertItem item) {
		this.myDessertItems[numberOfItems] = item;
		numberOfItems++;
	}
	
	public void clear() {
		for(int i = 0; i < numberOfItems; i++)
			this.myDessertItems[i] = null;
		numberOfItems = 0;
	}
	
	public int totalCost() {
		int sum = 0;
		for(int i = 0; i < numberOfItems; i++) 
			sum += myDessertItems[i].getCost(); 
		return sum;
	}
	
	public int totalTax() {
		return (int)Math.round(this.totalCost() * DessertShoppe.TAX_RATE / 100.00);
	}
	
	public String toString() {
		String s = "";		// receipt
		
		
		s += "    " + DessertShoppe.STORE_NAME + "\n";
		s += "    " + "--------------------" + "\n";
		
		for(int j = 0; j < numberOfItems; j++){
		
			String l = myDessertItems[j].getName();		// items of every line
			
//			String item = myDessertItems[j].getClass().toString().substring(6);		// get the item category
			
			String p = DessertShoppe.cents2dollarsAndCents(myDessertItems[j].getCost());	// price of every item
			if (p.length() > DessertShoppe.COST_WIDTH)		// verify the price is within length
				p = p.substring(0, DessertShoppe.COST_WIDTH);
			
			if (myDessertItems[j] instanceof IceCream) {		// print if ice cream
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";
			}
			else if (myDessertItems[j] instanceof Sundae) {		// print if Sundae
				
				s += ((Sundae)myDessertItems[j]).getTopping() + " Sundae with\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";
			}
			else if (myDessertItems[j] instanceof Candy){		// print if Candy
				s += ((Candy) myDessertItems[j]).getWeight() + " lbs @ " + 
						DessertShoppe.cents2dollarsAndCents(((Candy) myDessertItems[j]).getPricePerPound()) + " /lb.\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";	
			}
			else {		// print if Cookie
				s += ((Cookie)myDessertItems[j]).getNumber() + " @ " + 
						DessertShoppe.cents2dollarsAndCents(((Cookie)myDessertItems[j]).getPricePerDozen()) + " /dz\n";
				
				while(l.length() < RECEIPT_WIDTH - p.length()){
					l += " ";
				}
				s += l + p + "\n";			
			}	
		}
		
		String line = "\nTax";		
		String tax = DessertShoppe.cents2dollarsAndCents(this.totalTax());	// print tax
		while(line.length() <= RECEIPT_WIDTH - tax.length())
			line += " ";
		s += line + tax;
		
		String totalCost = DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax());	// print total cost
		line = "\nTotal Cost";
		while(line.length() <= RECEIPT_WIDTH - totalCost.length())
			line += " ";
		s += line + totalCost;
	
		return s;
	}
}