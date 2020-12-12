import java.util.*;
public class  CarNavigation{
	public static void main(String[] args) {
	// **First assign values to attributes of car using the different methods **\\

int positionX = randomizePosition();   // random x coordinate 
int positionY=  randomizePosition(); // random y coordinate 
char color = assignColor();  //random colour assigned 
boolean ignition = false ; // ignition set to off  
String positionCar = "(" + positionX + "," + positionY +")"; // position as x and y coordinates 
//System.out.println(positionCar );
//System.out.println(positionY );


//Now present user with menu options //

Scanner input = new Scanner(System.in);

System.out.println("what would you like to do?"); 
System.out.println("1: turn the ignition on/off"); 
System.out.println("2: change the position of car"); 
System.out.println("Q: quit this program"); 
System.out.println("Input: "); 

String  choice = input.next() ;

switch (choice){
	case "1":
	ignition = ignitionSwitch(ignition); 
	reportState(ignition, color, positionX, positionY); 
	break; 

	case "2":  // if user tries to move the car without turning on ignition, they won't be able to proceed 
	if (!ignition){
	System.out.println("Please turn on the ignition to be able to move the car \n");
	reportState(ignition, color, positionX,  positionY);} 
	break;

	case "Q":
	System.out.println("Program has ended \n");
	reportState(ignition, color, positionX, positionY);
    System.exit(0);
    break; 

    default: System.out.println("Error! incorrect Input:  " + choice); 
    System.out.println("Please choose 1, 2 or Q");

	}

	while (choice != "Q"){
	System.out.println("\nwhat would you like to do?"); 
	System.out.println("1: turn the ignition on/off"); 
	System.out.println("2: change the position of car"); 
	System.out.println("Q: quit this program"); 
	System.out.println("Input: "); 

	String  choice2 = input.next() ; 
	switch (choice2){
	case "1" :
	ignition = ignitionSwitch(ignition); 
	if  (!ignition){
			System.out.println("Ignition is off! Please turn on the ignition to be able to move the car\n");}
	System.out.println("\n"); 
	reportState(ignition, color, positionX, positionY); 
	break; 

	case "2": 
		if (!ignition){
			System.out.println("Ignition is off! Please turn on the ignition to be able to move the car\n");
			reportState(ignition, color, positionX,  positionY);}
		else{
   			System.out.println("In which direction do you want to move the car?");
   			System.out.println("H: Horizontal"); 
   			System.out.println("V: Vertical"); 
   				String pos = input.next();
   				switch  (pos){
         			case "H":
         				System.out.println("Enter Movement Distance"); 
         				int corx = input.nextInt();
         				int posX = positionX; 
         				int newcorx = moveHorizontally (posX, corx, ignition); 
         				reportState(ignition, color, newcorx,  positionY); 
         				positionX = newcorx; 
         			break; 

         			case "V":
         				System.out.println("Enter Movement Distance"); 
         				int cory = input.nextInt(); 
         				int posY = positionY; 
         				int newcory = moveHorizontally (posY, cory, ignition); 
         				reportState(ignition, color, positionX,  newcory); 
         				positionY = newcory; 
         			break;

         			default: System.out.println("Error! input " +  pos +  " is not correct for this option. Please choose H or V ");
         			}
         	}
	break;

	case "Q":
		System.out.println("\nProgram has ended");
		reportState(ignition, color, positionX, positionY);
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
			System.out.println("this distance movement will move the car out of bounds.");}
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
			System.out.println("this distance movement will move the car out of bounds.");}
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

System.out.println("Car Information");
System.out.println("Color:" +  colour); 
System.out.println("Ignition:" + IgnitionStatus); 
System.out.println("Location:" + location);
int result; 
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
