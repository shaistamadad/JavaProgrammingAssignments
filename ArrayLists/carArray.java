import java.util.Random;
import java.util.Scanner;
public class carArray{
	public static void main(String[] args) {
		
		// **define attributes for the ten cars ""//
		int [] cars = new int [10];
		for (int i = 0; i <= cars.length-1 ; i++) {
			cars[i]= i+1;}
		boolean [] ignitionArray = new boolean [10] ; 
		int [] positionX = new int [10];   //  initialise x coordinate array
		int [] positionY=  new int [10]; // initialise y coordinate  array
		char [] color = new char [10];  //initialise colour array

		//assign position and colour to all ten cars

		for (int i=0; i <= cars.length-1; i++)
			color[i]= assignColor(); 
	 
		for (int i=0; i <= cars.length-1; i++)
			 positionX[i]= randomizePosition(); 
		
		for (int i=0; i <= cars.length-1; i++)
			positionY[i]= randomizePosition(); 
		
		//""Ask for Car number **//
	
		Scanner input = new Scanner(System.in);
		System.out.println("Which car would you like to use? (Choose from 1-10)"); //error checking for input not required for this assignment 
		int carNum= input.nextInt(); 

		//after car has been chosen, ask the options// 

		//Note: After each action, the code asks to choose a new car. So if I turn on the ignition for car 1, the next step
		//would be to choose car 1 again and then choose option 2 to move it. 
		
		System.out.println("what would you like to do?"); 
		System.out.println("1: turn the ignition on/off"); 
		System.out.println("2: change the position of car"); 
		System.out.println("Q: quit this program"); 
		System.out.println("Input: "); 
	
		String  choice = input.next() ;

		switch (choice){
			case "1":
			ignitionArray[carNum-1] = ignitionSwitch(ignitionArray[carNum-1]); 
			System.out.println("Car Information"); 
			System.out.println("Car #" + carNum);
			reportState(ignitionArray[carNum-1], color[carNum-1], positionX[carNum-1], positionY[carNum-1]); 
			break; 

			case "2":  // if user tries to move the car without turning on ignition, they won't be able to proceed 
			if (!ignitionArray[carNum-1]){
			System.out.println("Please turn on the ignition to be able to move the car \n");
			System.out.println("Car Information"); 
			System.out.println("Car #" + carNum);
			reportState(ignitionArray[carNum-1], color[carNum-1], positionX[carNum-1], positionY[carNum-1]);} 
			break;

			case "Q":
			System.out.println("Program has ended \n");
			System.out.println("Car Information"); 
			System.out.println("Car #" + carNum);
			reportState(ignitionArray[carNum-1], color[carNum-1], positionX[carNum-1], positionY[carNum-1]);
		    System.exit(0);
		    break; 

		    default: System.out.println("Error! incorrect Input:  " + choice); 
		    System.out.println("Please choose 1, 2 or Q");

			}
		while (choice != "Q"){
			System.out.println("Which car would you like to use? (Choose from 1-10)"); 
			int carNum2= input.nextInt(); 
			System.out.println("\nwhat would you like to do?"); 
			System.out.println("1: turn the ignition on/off"); 
			System.out.println("2: change the position of car"); 
			System.out.println("Q: quit this program"); 
			System.out.println("Input: "); 

			String  choice2 = input.next() ; 
			switch (choice2){
			case "1" :
			ignitionArray[carNum2-1] = ignitionSwitch(ignitionArray[carNum2-1]); 
			if  (!ignitionArray[carNum2-1]){
					System.out.println("Ignition is off! Please turn on the ignition to be able to move the car\n");}
			System.out.println("\n"); 
			System.out.println("Car Information"); 
			System.out.println("Car #" + carNum2);
			reportState(ignitionArray[carNum2-1], color[carNum2-1], positionX[carNum2-1], positionY[carNum2-1]); 
			break; 

			case "2": 
				if (!ignitionArray[carNum2-1]){
					System.out.println("Ignition is off! Please turn on the ignition to be able to move the car\n");
					System.out.println("Car Information"); 
					System.out.println("Car #" + carNum2);
					reportState(ignitionArray[carNum2-1], color[carNum2-1], positionX[carNum2-1], positionY[carNum2-1]);}
				else{
		   			System.out.println("In which direction do you want to move the car?");
		   			System.out.println("H: Horizontal"); 
		   			System.out.println("V: Vertical"); 
		   				String pos = input.next();
		   				switch  (pos){
		         			case "H":
		         				System.out.println("Enter Movement Distance"); 
		         				int corx = input.nextInt();
		         				int posX = positionX[carNum2-1]; 
		         				int newcorx = moveHorizontally (posX, corx, ignitionArray[carNum2-1]); 
		         				System.out.println("Car Information"); 
		         				System.out.println("Car #" + carNum2);
		         				reportState(ignitionArray[carNum2-1], color[carNum2-1], newcorx,  positionY[carNum2-1]); 
		         				positionX[carNum2-1] = newcorx; 
		         			break; 

		         			case "V":
		         				System.out.println("Enter Movement Distance"); 
		         				int cory = input.nextInt(); 
		         				int posY = positionY[carNum2-1]; 
		         				int newcory = moveHorizontally (posY, cory, ignitionArray[carNum2-1]); 
		         				System.out.println("Car Information"); 
		         				System.out.println("Car #" + carNum2);
		         				reportState(ignitionArray[carNum2-1], color[carNum2-1], positionX[carNum2-1],  newcory); 
		         				positionY[carNum2-1] = newcory; 
		         			break;

		         			default: System.out.println("Error! input " +  pos +  " is not correct for this option. Please choose H or V ");
		         			}
		         	}
			break;

			case "Q":
				System.out.println("\nProgram has ended");
				System.out.println("Car Information"); 
				System.out.println("Car #" + carNum2);
				reportState(ignitionArray[carNum2-1], color[carNum2-1], positionX[carNum2-1], positionY[carNum2-1]);
		    	System.exit(0);
		    break; 

		    default: System.out.println("Error! incorrect input:  " + choice2); 
		    System.out.println("Please choose 1, 2 or Q");
		    

			}
			
			}
			} 







		/////*** Methods needed  ***/////



		public static boolean ignitionSwitch(boolean Value){ 

			if (!Value){Value = true;  
			}
			else 
				Value = false; 
			return Value; 

		}

		// method to get the initial random position for the car

		public static int randomizePosition(){

			 //d = Math.random();
			 int i; 
		     i = 1+ (int) (Math.random() * 20);
		     return i;
		}


		// method to assign a random colour to car 

		public static char assignColor(){
		Random rnd = new Random();
		String characters = "RGBWS";
		char randomChar = characters.charAt(rnd.nextInt(characters.length()));
		return randomChar; 
		}


		// method for horizontal movement 

		public static int moveHorizontally (int x, int userInput, boolean ignitionstatus){
			int NewXCoordinate = x; 
			if (ignitionstatus== true){
				NewXCoordinate = userInput + x; 
				if (NewXCoordinate<= 20 & NewXCoordinate >= 1  ){
					NewXCoordinate = NewXCoordinate; 
				}
				else
					{NewXCoordinate = x;
					System.out.println("ERROR! this distance movement will move the car out of bounds.");}
				}
			 else if (ignitionstatus== false) 
				{   
					System.out.println("Turn on ignition"); }; 

			return NewXCoordinate; 
		}

		// method to move car in vertical plane 

		public static int moveVertically (int y, int userInput, boolean ignitionstatus){
			int NewYCoordinate = y; 
			if (ignitionstatus== true){
				NewYCoordinate = userInput + y; 
				if (NewYCoordinate <= 20 & NewYCoordinate >= 1  ){
					NewYCoordinate = NewYCoordinate; 
				}
				else{
					NewYCoordinate = y;
					System.out.println("ERROR! this distance movement will move the car out of bounds.");}
				}
			else if  (ignitionstatus== false) 
				{   
					System.out.println("Turn on ignition"); };  

			return NewYCoordinate; 
		}

		//method to get the state of car 

		public static void reportState(boolean ignitionstatus, char color, int positionx, int positiony){

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

		String IgnitionStatus = ""; 
		if (ignitionstatus){
			IgnitionStatus = "On"; 
		}
		else  IgnitionStatus = "Off"; 

		String location = "(" + positionx + "," + positiony + ")"; 

		//System.out.println("Car Information");
		System.out.println("Color:" +  colour); 
		System.out.println("Ignition:" + IgnitionStatus); 
		System.out.println("Location:" + location);
		System.out.println("\n"); 

		for (int outer = 1; outer <= 20; outer ++) {  
				for (int inner = 1; inner <= 20; inner++)   // inner loop 
				    { 
					if ( inner == positionx & outer == positiony){
					    System.out.print( color); }
					else
					    System.out.print( "-");
					
					}  
				System.out.println();

			    } 

		}
		}

public static String getBin(int n)
	{
	    String s = "";
	    while (n > 0)
	    {
	        s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
	        n = n / 2;
	        //System.out.println(n);
	    }
	    return s;
	}
		
	
	public static String getHex(int n)
	{ 
	    String s = "";
	    while (n > 0)
	    {
	    	int term; 
	    	term= n%16; 
	    if (term >= 10 && term < 16 ) {

   		s=   (char) ('A' + term - 10) + s;}

   		else 
	    		s=  "" + term + s; 
	    	
	    	
	    n= n/16; 
   			 
   		 }
	    return s; 
	}







public static boolean sameValue( String binaryNumber,String hexNumber)
	{  //initialise all variables 
		     int  remainder;
	        String hexdecnum="";
	        int numAsInt=0;            
	        int binNum = Integer.parseInt(binaryNumber); //convert string to int

	        // first I will convert the binary number to the integer format
	        int i=0;      

	        while(binNum>0)
	        {
	            remainder = binNum%10;
	            binNum=binNum/10;
	            numAsInt = numAsInt + (int)(remainder*Math.pow(2,i));
	            i++;
	        }     
 
	        
	        //I have parameter binaryNumber reverted to integer format. 
	        //convert this integer to hexadecimal format and then compare with parameter hexNumber 
			
	        while(numAsInt>0)
	        {
	        	int term; 
		    	term= numAsInt % 16; 
		    	
		    		if (term >= 10 && term < 16 ) {
		    			hexdecnum=  (char) ('A' + term - 10) + hexdecnum;}
		    		
		    		else 
		    			{hexdecnum=  "" + term + hexdecnum; }
		    		
		    		
		    		numAsInt = numAsInt/16;
	        }
	       
	        boolean equality = hexdecnum.equals(hexNumber); 
	  return(equality);       
	}




