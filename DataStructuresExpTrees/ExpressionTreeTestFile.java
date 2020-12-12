import java.util.Scanner;

/*this file needs the following files to run:
1) Node.java 
2) ExpressionTree.java which is the expression tree class file with the 4 methods define 
3) ArrayStack.javam(from assignment10)
4) Stack.java (from assignment10)
5) Converter.java (from assignment10)
*/
public class ExpressionTreeTestFile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ExpressionTree<String> tree = new ExpressionTree<String>();
		Converter converter;
																
		boolean keepGoing = true;										
		String postFixexpression = "";															
		String infixExpression = "";
		int choice; 
		

		
		do{ 
		// get the user input for the infix expression 	
			System.out.println("Type your expression here: or press Ctrl-C to exit ");
			infixExpression = input.nextLine();	
			// evaluate the postfix expression to make sure the expression is valid
			converter = new Converter(infixExpression);						// to convert the postfix expression			
			postFixexpression = converter.toPostFix(converter.inFixString);	 // get the postfix expression using converter from last class
			
			

			//Build a tree using the post fix expression 
			tree = tree.convert(postFixexpression);													
			System.out.print("Prefix: ");
			tree.prefix();
			System.out.print("Infix: ");
			tree.infix();
			System.out.print("Postfix: " );
			tree.postfix(); } while (keepGoing); 
		 

    		}
    	
			

}