/**
 * 
 * @author Anna Debroux
 * CS 272 - Lab 4
 *This lab is to learn about singly linked list and to
 *learn basic operations for same
 */
public class IntNode {

	/**
	 * This class has two instance variables:  one for keeping an integer value, 
	 * and the other is a link pointing to another IntNode instance or pointing to null
	 */
	
	private int data;	//refers to the element stored in this node
	private IntNode link;	//refers to the next node in the list
	/**
	 * 2.  Create a no argument constructor which sets the node value to 0
	 * and the link to be null reference
	 * Postcondition:  This new node is empty and the head
	 * is the null reference
	 */
	public IntNode()
	{
		data = 0;
		link = null;
	}
	
	/**
	 * 3.  A constructor with the given node value and the link
	 * @param _data is the initial data of this new node
	 * @param _node is the reference to the next node
	 * Postcondition: This new node contains that integer data specified
	 * and a link to the next node
	 */
	public IntNode (int _data, IntNode _node)
	{
		data = _data;
		link=_node.getLink();
		_node.setLink(this);

	}

	/**
	 * 4.  Get and set methods to get the node value and node link
	 * Get method to retrieve data
	 * @return the data from this node is returned
	 */
	public int getData()	//Accessor method to retrieve information for integer value in each node
	{
		return data;
	}
	
	/**
	 * Get method to retrieve new link
	 * @return A reference to the node after this node is returned
	 */
	public IntNode getLink()	//Accessor method to get a reference to the next node after this node
	{
		return link;
	}
	
	/**
	 * Set method for integer data
	 * @param newData is the new data to be placed in this node
	 * Postcondition:  the data of this node has been set to newData
	 */
	public void setData(int newData)	//Mutator method to set the data in this node
	{
		data = newData;
	}
	
	/**
	 * Set method for IntNode link
	 * @param newLink is the reference to the node that appears
	 * after this new node (or the null reference if no node appears after)
	 * Postcondition:  The link to the node after this node has been set to
	 * newLink and any other node is no longer connected to this node
	 */
	public void setLink(IntNode newLink)	//Mutator method to set the reference to the next node after this node
	{
		link = newLink;
	}
	
	/**
	 * 5.  toString Method:  this method should return a String for the linked list, starting from the node that
	 * activates this method.
	 * Postcondition:  The data from each node is printed in the order it occurs from head to tail
	 */
	public String toString()
	{
		String answer = "";
		IntNode now = this;
		
		while(now != null) {
			//answer += ", ";
			answer += now.getData() +",";
			now = now.getLink();
			
		}
		
		return answer;
			
	}	

	/**
	 *  6.  A method to add a node after the current node.  This method should create a new node with the value newdata
	 * and let the current node's link point to this new node.
	 * @param newdata is the data to be placed in the new node
	 * Postcondition: A new node is created and placed after this node and the data for the new node is newdata.
	 * Any other node that used to be after this node are now after the new node
	 * throws OutOfMemoryError if there is insufficient memory for a new node
	 */
	public void addNodeAfterThis(int newdata)
	{
		   new IntNode(newdata, this);
		//IntNode next = new IntNode();
			
		}
		
	
	/**
	 * 7.  A method to remove the node after the current node. This method should remove the node that this node's link
	 * points to.
	 * Precondition:  This node must not be the tail node of the list
	 * Postcondition: The node after this node is removed from the list, but any other nodes that occurred after are still
	 * present.
	 * throws nullPointerException if this is the tail node of the list as there is nothing after it
	 */
	public void removeNodeAfterThis()
	{
		link = link.getLink();
	}
	
	/**
	 * 8.  A method to get the number of nodes in the list starting from a given node head.
	 * @param head is the reference to head node of the list (may be null and thus the list is empty)
	 * @return the number of nodes in the list with the given head
	 * Arithmetic overflow will occur if the number of nodes exceeds Int.MAX_VALUE
	 */
	public static int listLength(IntNode head)
	{
		IntNode cursor;
		int answer;
		
		answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.link)
			answer++;
		
		return answer;
	}
	
	/**
	 * 9.  A method to search whether a linked list starting with head contains a given value data.
	 * This method returns true if data exists in the linked list starting with head; and it return false otherwise.
	 * @param head is the reference to head node of a list
	 * @param target is the reference to the given value data being searched for
	 * @return true if the target data is in the list or false if the target data is not in the list
	 */
	public static boolean search(IntNode head, int target)
	{
		IntNode cursor;
		for(cursor = head; cursor != null; cursor = cursor.link)
			if(target == cursor.data)
				return true;
		return false;
	}

	//BEGIN LAB 5
	
	/*1.  A method to calculate the number of even elements in a linked list from the given head.  
	 * When head is null, return 0
	 */
	
	public static int listEvenNumber(IntNode head) {
		IntNode cursor;
		int answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.getLink()) {
			if(cursor.getData() % 2 == 0) {
				answer += 1;	
			}
		}
		return answer;
	}
	
	//2.  A method to add the given new data to the end of the linked list that starts from the current node
	
	public void addToEnd(int newdata) {
		
		IntNode head = this;
		
		while(head.getLink() != null) {
			head = head.getLink();
		}
		head.addNodeAfterThis(newdata);
	}
	
	
	//3.  A method to calculate the summation of elements in the last number of nodes in a given linked list
	
	public static int sumLast(IntNode head, int num) {
		IntNode cursor = head;
		int sum = 0;
		int start = IntNode.listLength(head) - num;
		int counter = 1;
		
		while(cursor != null) {
			
			if(counter > start || num > IntNode.listLength(head)) {
				sum = sum + cursor.getData();
			
			}
			cursor = cursor.getLink();
			counter++;
		}
		
		return sum;
	}
	
	
	
	//4.  Copy part of a given linked list
	
	public static IntNode copyOdd(IntNode head) {
		IntNode newHead = null;
		IntNode cursor = head;
		
		while(cursor != null) {
			if(cursor.getData() % 2 != 0) {
				if(newHead == null) {
					newHead = new IntNode();
					newHead.setData(cursor.getData());
				}
				else {
				newHead.addToEnd(cursor.getData());
			}
			
		}
		cursor = cursor.getLink();
	}
		return newHead;
		
	}
	
	/*5.  A method to remove all the nodes that have the data value e from the linked list starting from the given head.
	 *   This method should return the linked list with a new head.  If the head is null, the method should return null.
	 */
	/*public static IntNode removeAll(IntNode head, int e) {
		IntNode current = head;
		
		//if(current == null) return null;
		
		while(current != null) {
			if(current.getLink().getData()==e){
				current.removeNodeAfterThis();
				current = current.getLink();
			}
			return current;
		}
		return null;
	}*/
	
	/*public static IntNode removeAll(IntNode head, int e) {
		IntNode current;
		IntNode newHead = null;
		
		for(current = head; current != null; current = current.getLink()) {
			if(current.getLink().getData() != e){
				current.removeNodeAfterThis();
			}
			
		}
		return current;
		//return null;
	}*/
	
	public static IntNode removeAll(IntNode head, int e) {
		IntNode newHead = null;
		IntNode current = head;
		
		while(current != null) {
			if(current.getData() != e) {
				if(newHead == null) {
					newHead = new IntNode();
					newHead.setData(current.getData());
					
				}
				else {
					newHead.addToEnd(current.getData());
			}
			
		}
		current = current.getLink();
	}
		return newHead;
		
	}
	
	//6.  A method to reverse a linked list
	
	public static IntNode reverse(IntNode head) {
		IntNode source = head;
		IntNode copyHead = null;
		IntNode newHead = null;
		
		while(source != null) {
			copyHead = new IntNode();
			copyHead.setData(source.getData());
			copyHead.setLink(newHead);
			newHead = copyHead;
			source = source.getLink();
		}
		return newHead;
	}
	
	
	//7.  A method to test whether a linked list starting from the given head is cyclic or acyclic.
	
	public static boolean hasCycle(IntNode head) {
		if(head == null) return false;
		IntNode fast = head.link;
		IntNode slow = head;
		
		while(fast != null && fast.link != null && slow != null) {
			if(fast == slow) {
				return true;
			}
			fast = fast.link.link;
			slow = slow.link;
		}
		return false;
	}
}
	


