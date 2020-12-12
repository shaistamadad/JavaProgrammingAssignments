import java.util.*; 
public class  TestSmallInt{
	public static void main(String[] args) {

		SmallInt name= new SmallInt(8);  // instantiated my small int object and give it an initial random value  
		int maxValue = name.MAXVALUE;  // got the max value from small int class 

		Scanner scan= new Scanner(System.in);
	    System.out.println("Please enter a number between 0 and  " + maxValue);
		int myNumber= scan.nextInt(); 
		if  (myNumber < maxValue && myNumber > 0){

		name.setDec(myNumber);  
		String binaryRepresenation= name.getBin();
		System.out.println("Binary representation of your number is  " + name.getBin()); 
		String decimalRepresenation= name.getHex();
		System.out.println("Hexadecimal representation of your number is   " + name.getHex());

		System.out.println( "boolean outcome for sameValue static method for your number is:" 
			+ name.sameValue( binaryRepresenation,decimalRepresenation));
	}

	else{ System.out.println( " Please enter a number between 0 and " + maxValue); }



	}




}
		




						








