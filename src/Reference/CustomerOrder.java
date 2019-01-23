package Reference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerOrder {

	private String firstName;
	private String lastName;
	private String flavor;
	private String topping;
	private String coc;
	private double price;
	private String date;

	
	public CustomerOrder() {
		
		this.firstName = "Emily";
		this.lastName = "Andrade";
		this.flavor = "Strawberry";
		this.topping = "Sprinkles";
		this.coc = "Cup";
		this.price = 0;
		this.date = "2018-04-30";
	}
	
	public CustomerOrder(String firstName, String lastName, 
			String flavor, String topping, String coc, String price, String date) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.flavor = flavor;
		this.topping = topping;
		this.coc = coc;
		double temp = Double.parseDouble(price);
		this.price = temp;
		this.date = date;
		
	}
	
	public CustomerOrder(String firstName, String lastName, 
			String flavor, String topping, String coc) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.flavor = flavor;
		this.topping = topping;
		this.coc = coc;
		
	}
	
	public void setfirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	public String getfirstName() {
		
		return this.firstName;
	}
	
	public void setlastName(String lastName) {
		
		this.lastName = lastName;
	}
	
	public String getlastName() {
		
		return this.lastName;
	}
	
	public void setflavor(String flavor) {
		
		this.flavor = flavor;
	}
	
	public String getflavor() {
		
		return this.flavor;
	}
	
	public void settopping(String topping) {
		
		this.topping = topping;
	}
	
	public String gettopping() {
		
		return this.topping;
	}
	
	public void setcoc(String coc) {
		
		this.coc = coc;
	}
	
	public String getcoc() {
		
		return this.coc;
	}
	
	public String getCurrentDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		return df.format(date);
	}
	
	public double getprice() {
	
		if(this.flavor == "Chocolate") {
			this.price += 2.50;
		}
		else if(this.flavor == "Vanilla"){
			this.price += 2.50;
		}
		else if(this.flavor == "Chocolate Chip Mint"){
			this.price += 3.00;
		}
		else if(this.flavor == "Rocky Road"){
				this.price += 3.50;
		}
		else if(this.flavor == "Strawberry"){
			this.price += 3.00;
		}
		
		else if(this.topping == "Sprinkles") {
			this.price += .25;
		}
		else if(this.topping == "Chocolate syrup"){
			this.price += .50;
		}
		else if(this.topping == "Pineapple"){
			this.price += .50;
		}
		else if(this.topping == "Whipped Cream"){
			this.price += .10;
		}
		else if(this.topping == "Bacon Bits(NEW!)"){
			this.price += 1.00;
		}
		else {
			this.price += 0.00;
		}
			 
		return this.price;
	}
	
	public String toString() {
		
		return "First Name: " + getfirstName() + "\nLast Name: " + getlastName() +
				"\nFavorite Flavor: " + getflavor() + "\nTopping: " + 
				gettopping() +"\nCup or Cone: " + getcoc() +
				"\nPrice: " + getprice();
	}
}
