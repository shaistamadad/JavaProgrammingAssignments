
public class Node<T> {
	public T element;						
	public Node<T> rightChild;	
	public Node<T> leftChild;	

	public Node (T o) {				// constructor to create a new node
		this.element = o;
		leftChild = null;
		rightChild = null;
	}
	
	public void setInfo(T o) {		
		this.element = element;
	}
	
	public void setLeftChild(Node<T> leftChild) {	
		this.leftChild = leftChild;
	}
	
	public void setRightChild(Node<T> rightChild) {	
		this.rightChild = rightChild;
	}
	
	public String toString() {
		return "" + element;
	}
}

