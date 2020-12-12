import java.util.Random;
public class carObjects{
	boolean ignition ; 
	int positionX; 
	 int positionY; 
	 char color; 


//constructor created with four attributes: ignition, colour, positionX and position Y

	public carObjects(){
	 this.ignition = ignition; 
	 this.color= assignColor(); 
	 this.positionX= randomizePosition(); 
	 this.positionY= randomizePosition(); 
	}



// method to assign a random colour to car 

		public  char assignColor(){
		Random rnd = new Random();
		String characters = "RGBWS";
		char randomChar = characters.charAt(rnd.nextInt(characters.length()));
		return randomChar; 
		}

	//method to move horizontally within 20X20 grid 
	 public  void  moveHorizontal (int userInput){
	 	boolean ignitionstatus= this.ignition; 
	 	int x= this.positionX; 
			int NewXCoordinate = x; 
			if (ignitionstatus== true){
				NewXCoordinate = userInput + x; 
				if (NewXCoordinate<= 20 & NewXCoordinate >= 1  ){
					this.positionX = NewXCoordinate; 
				}
				else
					{
					System.out.println("ERROR! this distance movement will move the car out of bounds.");}
				}
			 else if (this.ignition== false) 
				{   
					System.out.println(" Please turn on  the ignition first"); }; 

		}


//move to move vertically on a 20X20 grid  
public  void moveVertical (int userInput){
	boolean ignitionstatus= this.ignition; 
	 	int y= this.positionY; 
			int NewYCoordinate = y; 
			if (ignitionstatus== true){
				NewYCoordinate = userInput + y; 
				if (NewYCoordinate <= 20 & NewYCoordinate >= 1  ){
					this.positionY= NewYCoordinate; 
				}
				else{
					System.out.println("ERROR! this distance movement will move the car out of bounds.");}
				}
			else if  (ignitionstatus== false) 
				{   
					System.out.println("Turn on ignition"); };  
		}

//ignitionSwitch: This method will turn the car off when it is on or on when it is off. (i.e. change the value of the instance
//variable
		public void ignitionSwitch(){ 
		boolean ignition= this.ignition; 

			if (!ignition){this.ignition = true;  
			}
			else 
				this.ignition = false;  

		}

		// method to get the initial random position for the car

		public  int randomizePosition(){
			 int i; 
		     i = 1+ (int) (Math.random() * 20);
		     return i;
		}

//getColor  This method will return the color of the car as string
	public String getColor(){
		color= this.color;
		String colour = ""; // string initialised to be populated by colour of car 
		switch (color){
			case 'R': 
			colour = "Red"; break; 
			case 'G':
			colour = "Green"; break;
			case 'B':
			colour = "Black"; break;
			case 'W':
			colour = "White"; break;
			case 'S':
			colour = "Silver"; break;
		}
		return colour; 
	}

//getIgnition This method will return the ignition status of the car as a boolean variable

public String getIgnition(){
	boolean ignition = this.ignition; 
	String IgnitionStatus = ""; 
		if (ignition){
			IgnitionStatus = "On"; 
		}
		else  {IgnitionStatus = "Off";} 

		return IgnitionStatus; 
}

//getX:: This method will return the x position of the car as an int.

public int getX(){
	int postionX= this.positionX; 
	return positionX; 
}

//getY:  This method will return the y position of the car as an int.

public int getY(){
	int positionY= this.positionY; 
	return positionY; 
}

public void getState(){
	    char color= this.color; 
		String colour= getColor(); 
		String ignition = getIgnition(); 
		int postionX= getX(); 
		int positionY= getY();  
		String location = "(" + postionX+ "," + positionY+ ")"; 

		System.out.println("Color:" +  colour); 
		System.out.println("Ignition:" + ignition); 
		System.out.println("Location:" + location);
		System.out.println("\n"); 

		for (int outer = 1; outer <= 20; outer ++) {  
				for (int inner = 1; inner <= 20; inner++)   // inner loop 
				    { 
					if ( inner == positionX & outer == positionY){
					    System.out.print(color); }
					else
					    System.out.print( "-");
					
					}  
				System.out.println();

			    } 

		}


	
}