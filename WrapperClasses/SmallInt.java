 class  SmallInt{
 	private int value; // Data field 

 	static int MAXVALUE= 1000; 

   //Constructor to assign value between 0 and max value//

 	SmallInt(int value){
 		if (value <= MAXVALUE && value >=0){
 		this.value=value;}
 		else {value= 0; 
 		System.out.println("Value can only be between 0 and " + MAXVALUE);}
 	}

// instance getter method to return string representation
	 
public String getDec(){
	String valueString= "" + value; 
	return valueString; 
	
}

//instance setter method to assign value between 0 and max value

	 public void setDec(int newValue){
	 	if (newValue <= MAXVALUE && newValue >= 0){
	 	this.value= newValue; }
	 	else {value= 0; 
	 		System.out.println("Value can only be between 0 and " + MAXVALUE); 
	 }
	}


//method to get  binary reprsentation of the int value for the object small int 

public String getBin() {

	    //n is the value of the integer for which we calculate the binary presenation
	   //let's suppose n= 98
		// n is assigned the value of the integer value of the object created from SmallInt class
		int n =this.value; 

		//initialise a string which will store the binary presentation
		String binary = "";

		//initialise an int variable to store the remainder from mod division 
		int term; 

		//start a for loop to divide the int value constantly by 2.
		//at each division, if the remainder=0, update the binary string with 0 
		//at each division,if remainder is not 0, update the string with 1
		// the logic is since the remainder of division by 2 is between 0 and 1 and we want only int values for remainder
		// the remainder values can only be 0 and 1. 
		//so first iteration gives term= 99%2=1, hence String binary will be updated to 1 , and n will become 99/2=49
		//at second iteration, 49%2= 1, hence binary is updated to 11, and n will become 49/2= 24
		//at third iteration, 24%2= 0, hence binary is updated to 011 and n= 24/2= 12
		//at fourth iteration, 12%2= 0, hence binary= 0011 n= 12/2=6
		//at fifth iteration, 6%2= 0, binary= 00011, n= 6/2=3
		//at sixth iteration, 3%2=1, binary= 100011,n = 3/2= 1
		//at 7th iteration 1%2= 1, binary= 1100011, n= 1/2=0
		//n= 0, loop ends, binary represenation = 1100011

	    while (n > 0){  

	    	term = n%2;  
	    	if (term ==0) {
	    		binary= "" + 0  +binary; 
	    	}
	    	else {
	        binary =  "" + 1 + binary;}
	        n = n / 2;
	        //System.out.println(n);
	    }
	    return binary;
	}
		

// method to get hexadecimal represenation of a number 
// let's use a bigget number this time n=1000
	
	public  String getHex()
	{   int n =this.value;; 
	    String s = "";

	  // at first iteration, term= 1000%16= 8, hence first term of hexadecimal representation is 8, n=1000/16=62
	  // at second iteration,  term = 62%16= 14, equivalent hex character is E, s  become E8, n= 62/16=3
	   // at third iteration, term= 3%16= 3, s becomes 3E8, n/16= 0, hence loop ends, decimal presenation is 3E8
	    while ( n> 0)
	    {
	    	int term; 
	    	term= n%16; // will be between 0 and 15. while term is >0 and <10, it's simply concatenated to the String value 
	    	//if term is between 10 and 15, we will need to use the equivalent hex characters. 10=A, 11=B, 12=C, 13=D, 14=E,15=F
	    if (term >= 10 && term < 16 ) {

   		s=   (char) ('A' + term - 10) + s;} // example: if term=14, term-10= 4, int value for 'A' + 4= 69, char of this becomes E. 
   		// adding a char to an int returns an int type, to get a char type back, will cast the addition value as char, 
   		//so (char) ('A' + 1) gives B (for term=11), 'A'+ 2 gives C (12), 'A' + 3 gives D (13), 'A'+ 4 gives  E (14), 'A'+5 gives F(15)
   		//E can be concatenated to the string s 

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
}

	    

						

											
						
