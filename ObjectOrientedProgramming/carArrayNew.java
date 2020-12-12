import java.util.Scanner;  
public class carArrayNew{
	public static void main(String[] args) {

	//Assign attributes (colour, ignition status and location) to 10 cars before giving user the menu. 

		carObjects[] carArray=  new carObjects[10]; 
		for (int i = 0; i < carArray.length; i++) {
  carArray[i] = new carObjects();
}


Scanner input = new Scanner(System.in);
System.out.println("Which car would you like to use? (Choose from 1-10)"); 
int carNum= input.nextInt();
System.out.println("Car# " + carNum +  " Information:");   
carArray[carNum].getState(); 

System.out.println("what would you like to do?"); 
		System.out.println("1: turn the ignition on/off"); 
		System.out.println("2: change the position of car");
		System.out.println("3: change cars");
		System.out.println("Q: quit this program"); 
		System.out.println("Input: "); 
String  choice = input.next() ;

switch (choice){
			case "1":
			carArray[carNum].ignitionSwitch(); 
			System.out.println("Car# " + carNum +  " Information:");   
			carArray[carNum].getState();  
			break; 

			case "2":  // if user tries to move the car without turning on ignition, they won't be able to proceed 
			if (!carArray[carNum].ignition){
			System.out.println("Please turn on the ignition to be able to move the car \n");
			System.out.println("Car# " + carNum +  " Information:");   
			carArray[carNum].getState(); 
			break;}

			case "3":
			System.out.println("Which car would you like to use? (Choose from 1-10)"); 
			carNum= input.nextInt();
			System.out.println("Car# " + carNum +  " Information:");   
			carArray[carNum].getState(); 
			break; 

			case "Q":
			System.out.println("Program has ended \n");
			System.out.println("Car# " + carNum +  " Information:");   
			carArray[carNum].getState(); 
		    System.exit(0);
		    break; 

		    default: System.out.println("Error! incorrect Input:  " + choice); 
		    System.out.println("Please choose 1, 2 or Q");

			}

while (choice != "Q"){
			System.out.println("what would you like to do?"); 
			System.out.println("1: turn the ignition on/off"); 
			System.out.println("2: change the position of car");
			System.out.println("3: change cars");
			System.out.println("Q: quit this program"); 
			System.out.println("Input: "); 

			String  choice2 = input.next() ; 
			switch (choice2){
			case "1" :
			carArray[carNum].ignitionSwitch(); 
			System.out.println("Car# " + carNum +  " Information:");   
			carArray[carNum].getState();  
			break; 

			case "2": 
			if (!carArray[carNum].ignition){
				System.out.println("Please turn on the ignition to be able to move the car \n");}
			else{
		   		System.out.println("In which direction do you want to move the car?");
		   		System.out.println("H: Horizontal"); 
		   		System.out.println("V: Vertical"); 
		   		String pos = input.next();
		   			switch  (pos){
		         	case "H":
		         	System.out.println("Enter Movement Distance"); 
		         	int corX = input.nextInt();
		         	carArray[carNum].moveHorizontal(corX);  
		         	break; 

		         	case "V":
		         	System.out.println("Enter Movement Distance"); 
		         	int corY = input.nextInt();
		         	carArray[carNum].moveVertical(corY);  
		         	break;

		         	default: System.out.println("Error! input " +  pos +  " is not correct for this option. Please choose H or V ");
		         			    }
		         	}

		    System.out.println("Car# " + carNum +  " Information:");   
			carArray[carNum].getState(); 
			break;

			case "3":
			System.out.println("Which car would you like to use? (Choose from 1-10)"); 
			carNum= input.nextInt();
			System.out.println("Car# " + carNum +  " Information:");   
			carArray[carNum].getState(); 
			break; 

			case "Q":
				System.out.println("\nProgram has ended");
				System.out.println("Car Information"); 
				System.out.println("Car# " + carNum +  " Information:");   
				carArray[carNum].getState(); 
				System.exit(0);
		    break; 

		    default: System.out.println("Error! incorrect input:  " + choice2); 
		    System.out.println("Please choose 1, 2,3 or Q");

			}


		}
}
					  }
