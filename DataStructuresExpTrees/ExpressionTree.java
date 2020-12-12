
import java.util.Scanner;
@SuppressWarnings("unchecked")

public class ExpressionTree<T> {
	public Node<T> root;				
	
	public ExpressionTree() {	 // constructor for expression tree
		root = null;
	}
	
	public ExpressionTree(T element) {
		root = new Node<T>(element);
	}

//Methods 1) convert(), which takes a postfix expression and creates an expression tree out of it

//Steps for creating an expression tree our of a postfix expression 
	 //1)Create an empty stack. Each element in the stack is going to be an expression tree, so set the generic type accordingly

	public ExpressionTree<T> convert(String postFixexpression) {
		ArrayStack<ExpressionTree<T>> stack = new ArrayStack<ExpressionTree<T>>();		
		Scanner listTerms = new Scanner(postFixexpression);
		
		while(listTerms .hasNext()) {
		//	If the token is a number, create a new expression tree node that
		//	represents just that number and push it onto the stack
														
			if (listTerms .hasNextInt()) {														
				String number = String.valueOf(listTerms .nextInt());
				ExpressionTree<T> numberTreeNode= new ExpressionTree<T>((T)number); 
			stack.push(numberTreeNode);		
			}
			else {	
			//If the token is an operator, create a new operator expression. Pop two
			//expressions off the top of the stack, and set them as children of this new
			//node. Then push the node onto the stack	

				ExpressionTree<T> leftChild;  //initialize the two children nodes 
				ExpressionTree<T> rightChild;
				T operator = (T)listTerms.next();
				ExpressionTree<T> operatorNode = new ExpressionTree<T>(operator);
				
				rightChild = stack.top();																	
				stack.pop();
				leftChild = stack.top();																		
				stack.pop();
				
				operatorNode.root.setLeftChild(leftChild.root);	  //set the children nodes as children of new operator node 									
				operatorNode.root.setRightChild(rightChild.root);								
				
				stack.push(operatorNode);												
			}
		}
		//Once all the tokens in the postfix expression have been processed, the stack will
		//contain only one expression tree. Pop it out, and return it.
		return stack.top();
	}


	//Method 2: prefix(), a preorder traversal of the tree
	// Preorder traversal prints the node data first.
	
	public  void prefix() {  //used as a driver for real prefix method
		prefix(root);
		System.out.println();
	}
	
	private void prefix(Node<T> node) {
		if (node != null) {
			System.out.print(node + " ");
			prefix(node.leftChild);
			prefix(node.rightChild);
		}
	}
	

	//Method 3: infix(), an inorder traversal of the tree

	//Inorder traversal will print the left child, followed by the operator, followed by the right
	//child. The result should look very similar to the original expression that was typed in by
    //the user. This needs to be surrounded by parenthesis in order to specify the correct order of operations.

	public void infix() {    //used as a driver for real infix method
		infix(root);
		System.out.println();
	}
	
	private void infix(Node<T> node) {
		if (node.leftChild != null) {
			System.out.print("( ");
			infix(node.leftChild);
		}
		System.out.print(node + " ");
		if (node.rightChild!= null) {
			infix(node.rightChild);
			System.out.print(" )");
		}
	}
//Method 4: postfix(), a postorder traversal of the tree
	//postorder traversal of a tree prints the children of the node first, and then
	//prints the data inside the node	
	
	public void postfix() {
		postfix(root);
		System.out.println();
	}
	
	private void postfix(Node<T> node) {
		if (node != null) {
			postfix(node.leftChild);
			postfix(node.rightChild);
			System.out.print(node + " ");  //print root at the end 
		}
	}
	

	
}