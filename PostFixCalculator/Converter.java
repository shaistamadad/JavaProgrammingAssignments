/*A Converter class that will convert the input string to postfix expression. A
Calculator class that will evaluate the postfix expression.*/

import java.util.*;

public class Converter{

//When the Converter class is instantiated, a String is passed representing the infix
String inFixString; 

// Constructor for convertor which takes in the string input given by the user for calculation 

public Converter(String input){
	this.inFixString= input; 

}

//The method that does all the work in the Converter class is called toPostFix().
// toPostFix() will convert the infix expression to a postfix expression. 
//The postfix expression is a string that will be evaluated by the calculator. 
//Each operator and operand  is separated by spaces.

//The first thing the toPostFix method does is to tokenize the input string into a list of
//tokens representing operators and operands. Parenthesis are also allowed in
//infix expressions, so "(" and ")" are valid tokens. 

public String toPostFix(String infixexpression){
// create a stack to store the operators/add to output string  
ArrayStack<String> stack = new ArrayStack<String>(20);	


 //initialised an output string. 
String outputString= "";     
List<String> tokenizeExpression;
String stackOperator;  // stores the top operator from stack and adds to output string 

// Step 1: tokenize the expression using ParserHelper method provided with this assignment,
// need to convert the infix string into a char array for input into the parser  method
char[] input= inFixString.toCharArray(); 
tokenizeExpression= parse(input);


for (String token: tokenizeExpression) {		// go through the tokenized infix expression one token at a time 
			if (isNumber(token))		// Whenever we come upon an operand, append it to the end of the output string. 
				outputString += token + " ";

			else if (token.equals("("))			// Whenever we come upon an open parenthesis, always put it on the stack as it has higher precedence 
				stack.push(token);

			else if (token.equals(")")) {		//if we reach end of the expression in parenthesis and find no operator,throw an error
				if (stack.isEmpty())		// there should be operators in the stack, this is a control check
					throw new ConverterException("There should be operators in the stack");
				else {
					/* pop out all the operators on the stack and append them to the output string until 
					   we reach open parenthesis in the stack  
					  we will stop popping tokens if the stack becomes empty.*/

					while (!stack.isEmpty()) {
						stackOperator = stack.top();		// get the top operator on the stack
						if (!stackOperator.equals("(")) {		// keep adding the stack operators to output string till we reach "("
							outputString   += stackOperator + " ";
							stack.pop();  // remove that operator from the stack 
						}
						else 
							break;		// 
					}
					if (stack.isEmpty())		// this is an error checking step to make sure the input expression given by user has parenthesis in pairs. 
						throw new ConverterException("There should be an open parenthesis complementary to the close parenthesis"); // if the user forgot open parenthesis, this will throw an exception 
					else
						stack.pop();	// remove the open parenthesis from the stack 
				}	
			}

			else {		
				if (stack.isEmpty())	
					stack.push(token);
				else {
					/* 	If the token has lower precedence (e.g., token is "+"" and top of stack is "*""):  
						- Then, pop operators out of the stack and append them to the output string.
						- Stop popping stack elements once the top of the stack has lower precedence than the current token.
						- Stop popping elements if the stack becomes empty.*/

					while (!stack.isEmpty()) {
						stackOperator = stack.top();
						if (tokenHasLowerPrecedence(stackOperator, token) && 
								!stackOperator.equals("(")) {  // ( is not added to output string 
							outputString   += stackOperator + " ";
							stack.pop();	
						}
						else 
							break;	
					}
					stack.push(token);		// add the token to stack after adding higher precedence stack operators to output string 
				}	
			}
		}	
		while (!stack.isEmpty() ) {		
			if(!stack.top().equals("(")) {
				outputString   += stack.top() + " ";
				stack.pop();
			}
			else
				throw new ConverterException("Close parenthesis is missing");
		}

		return outputString  ;
	}



private boolean tokenHasLowerPrecedence(String stackOperator, String token) {
		// this method returns true if the token has lower precedence 
			if ((token.equals("^")) && (stackOperator.equals("+") || stackOperator.equals("-") || 
					stackOperator.equals("*") || stackOperator.equals("/") ||
					stackOperator.equals("(")))
				return false;
			else if ((token.equals("*") || token.equals("/")) && (stackOperator.equals("+") || stackOperator.equals("-") ||
			stackOperator.equals("(")))
				return false;
			else if ((token.equals("+") || token.equals("-")) && (stackOperator.equals("(")))
				return false;
			else
				return true;
		}
	
	private boolean isNumber(String element) {
		//this method returns true if the token is numeric/ an operand 
		boolean numeric = true;
		try { 
	      int num=   Integer.parseInt(element); 
	    } catch(NumberFormatException e) { 
	        numeric = false; 
	    }
	   
	    return numeric;
	}



	public List<String> parse(char[] input) {
		// this method returns the in fix expresion as a list of strings 
	    List<String> parsed = new ArrayList<String>();
	    for (int i = 0; i < input.length; ++i) {
	        char c = input[i];
	        if (Character.isDigit(c)) {
	            String number = input[i] + "";
	            for (int j = i + 1; j < input.length; ++j) {
	                if (Character.isDigit(input[j])) {
	                    number += input[j];
	                    i = j;
	                } else {
	                    break;
	                }
	            }
	            parsed.add(number);
	        } else if (c == '*' || c == '/' || 
	                   c == '+' || c == '^' || 
	                   c == '-' || c == '(' || c == ')') {
	            parsed.add(c + "");
	        }
	    }
	    return parsed;
	}

	private static class ConverterException extends RuntimeException {
	
	public ConverterException() {
		super();
	}
	
	public ConverterException(String message) {
		super(message);
	}

}

}
	

