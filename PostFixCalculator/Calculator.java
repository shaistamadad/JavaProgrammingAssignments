import java.util.*;

/* This file requires 3 other files  to compile: 
1) Converter.java // this class takes the input from user and converts it into postfx expression 
2) Stack.java: stack interface with the methods required for the stack class 
3) ArrayStack.java  // this class has the constructor and methods required to create a stack for infix to post fix conversion and calculation of postfix expression 

*/

public class Calculator{
	public static void main(String[] args) {
		ArrayStack<Integer> stack= new ArrayStack<Integer>(20); 
		
		Scanner input = new Scanner(System.in);
		boolean keepGoing= true; 
		String line = null;		// get the input infix expression
		String output = null;	// get the postfix expression
		int result; 
		
		
		System.out.println("type your infix expression: ");
		line = input.next();
		
		Converter convertor= new Converter(line); 
		output = convertor.toPostFix(convertor.inFixString);
		result = evaluatePostfixexpression(output);
		System.out.println("coverted to postfix: " + output);
		Double d2=Double.valueOf(result);
		System.out.println("answer is:  " + d2);


		int choice; 
		do {
			System.out.println("Press 1 if you want to continue using the Calculator, press 2 if you would like to exit" );
			 choice= input.nextInt(); 
		      } while (choice != 1 && choice != 2);

    		while(choice== 1){

    			System.out.println("type your infix expression: ");
    			String line2 = input.next();
    			
    			Converter convertor2= new Converter(line2); 
    			String output2 = convertor2.toPostFix(convertor2.inFixString);
    			int result2 = evaluatePostfixexpression(output2);
    			System.out.println("coverted to postfix: " + output2);
    			Double d22=Double.valueOf(result2);
    			System.out.println("answer is:  " + d22);
    			System.out.println("Press 1 if you want to continue using the Calculator, press 2 if you would like to exit ");
    			choice= input.nextInt();
    			} 

    			if(choice== 2){
    				System.out.println("Program has ended"); 

    		}
    	



			}  

    


   
	/*Following is algorithm for evaluation postfix expressions. (Reference GeekforGeeks) 
	1) Create a stack to store operands (or values).
	2) Scan the given expression and do following for every scanned element.
	…..a) If the element is a number, push it into the stack
	…..b) If the element is a operator, pop operands for the operator from stack. Evaluate the operator and push the result back to the stack
	3) When the expression is ended, the number in the stack is the final answer */

   
	 // Method to evaluate value of a postfix expression 
    public static int evaluatePostfixexpression(String exp)
    { 
        //create a stack 
    	ArrayStack<Integer> stack = new ArrayStack<Integer>(50);
          
        // Scan all tokens one by one 
        for(int i = 0; i < exp.length(); i++) 
        { 
            char c = exp.charAt(i); 
              
            if(c == ' ') // if empty space, ignore 
            continue; 
              
            // If the scanned token is a number, put it on the stack 
            else if(Character.isDigit(c)) 
            { 
                int n = 0; 
                  
                //extract the operands and save it as n and then push it to stack 
                while(Character.isDigit(c)) 
                { 
                    n = n*10 + (int)(c-'0'); 
                    i++; 
                    c = exp.charAt(i); 
                } 
                i--; 
  
                //push the number in stack 
                stack.push(n); 
            } 
              
            // when we reach an operator in the post fix expression, pop two operands from stack
            //  apply the operator  on those two operands 
            else
            { 
                int val1 = stack.pop(); // operand 1 
             

                int val2 = stack.pop(); //operand 2 
              
                  
                switch(c) 
                { 
                    case '+': 
                    stack.push(val2+val1); 
                    break; 
                      
                    case '-': 
                    stack.push(val2- val1); 
                    break; 
                      
                    case '/': 
                    stack.push(val2/val1); 
                    break; 
                      
                    case '*': 
                    stack.push(val2*val1); 
                    break; 
                    
                    case '^': 
                    stack.push((int) Math.pow(val2, val1)); 
					break;
            } 
            } 
        }
       
        return stack.pop();  
    }


   
		



}