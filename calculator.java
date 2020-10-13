import java.util.Scanner;
public class  calculator{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String operator, op; 
		double firstInput, secondInput, answer;  //initialise all the variables I will need as doubles 
		double moreInput; 
		answer =0; 
			System.out.println("1st Input:");  //User will prompted to enter first number 

			firstInput= input.nextDouble();
			System.out.println("op:"); // user will be prompted to enter operator 

			operator = input.next(); //operator is a char datatype 

			switch(operator){     //block of code tells the program how to handle the first operator input 
				case "+":
				System.out.println("2nd Input");
				secondInput= input.nextDouble();
				answer = firstInput + secondInput;
				System.out.println("ans:\t"+ answer);
            	break;

         		case "-": 
         		System.out.println("2nd Input");
				secondInput= input.nextDouble();
				answer = firstInput- secondInput; 
				System.out.println("ans:\t"+ answer);
            	break;

         		case "*":
         		System.out.println("2nd Input");
				secondInput= input.nextDouble();
         		answer = firstInput * secondInput; 
         		System.out.println("ans:\t"+ answer);
            	break;

         		case "/": 
         		System.out.println("2nd Input");
				secondInput= input.nextDouble();
					if (secondInput == 0){
						System.out.println("Error: division by zero"); //handling  division by zero 
						answer = firstInput; 
						System.out.println("buffer:\t"+ answer);}
					else {
         				answer = firstInput/ secondInput;
         				System.out.println("ans:\t"+ answer);}
            	break;

            	case "x":
            	System.out.println("calculator exits");
            	System.exit(0);

            	case"c":
            	System.out.println("buffer is cleared"); 
            	answer= 0;
            	System.out.println("buffer:"+ answer);
            	break;

      			default: System.out.println("Error! incorrect operator:  " + operator); answer = firstInput;

			}

			//System.out.println("ans \t" + answer); 

			//this second block of code will continue the calcular operations after the first calculation 

			boolean x= true;  //boolean to start the loop to continue the calculator 

			while (x){

				System.out.println("op:"); 
				op = input.next();


				switch(op){
				case "+":
				System.out.println("more Input");
				moreInput= input.nextDouble();
				answer = answer + moreInput;
				System.out.println("ans:\t"+ answer);
            	break;

         		case "-": 
         		System.out.println("more Input");
				moreInput= input.nextDouble();
				answer = answer - moreInput; 
				System.out.println("ans:\t"+ answer);
            	break;

         		case "*":
         		System.out.println("more Input");
				moreInput= input.nextDouble();
         		answer = answer * moreInput;
         		System.out.println("ans\t"+ answer);
            	break;

         		case "/": 
         		System.out.println("more Input");
				moreInput= input.nextDouble();
					if (moreInput == 0){
						System.out.println("Error division by zero"); //handling division by zero
						answer = answer; 
						System.out.println("buffer:\t"+ answer);}
					else {
         				answer = answer/ moreInput;
         				System.out.println("ans:\t"+ answer);}
            	break;

            	case"x":
            	System.out.println("calculator exits"); 
            	System.exit(0);

            	case"c":
            	System.out.println("buffer is cleared");
            	answer= 0;
            	System.out.println("buffer:\t"+ answer);
            	break; 

      			default: System.out.println("Error! incorrect operator: " + op); answer = answer; } //handling incorrect operator 

			//System.out.println("ans\t"+ answer); 
			}
		
	



		}
	}