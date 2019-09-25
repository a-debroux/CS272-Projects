
public class IntNodeTest {

	public static void main(String[] args) {

		//create linked list nodes
		
		IntNode data1 = new IntNode();
		System.out.println("The void constructor test yields: " + data1.getData() + " for the data in this new node.");	//test void constructor
		data1.setData(9);
		IntNode data2 = new IntNode();
		data2.setData(15);
		data1.setLink(data2);
		IntNode data3 = new IntNode();
		data3.setData(7);
		data2.setLink(data3);
		IntNode data4 = new IntNode();
		data4.setData(15);
		data3.setLink(data4);
		IntNode data5 = new IntNode();
		data5.setData(25);
		data4.setLink(data5);
		IntNode data6 = new IntNode();
		data6.setData(2);
		data5.setLink(data6);
		IntNode data7 = new IntNode();
		data7.setData(900);
		data6.setLink(data7);
		data7.addNodeAfterThis(16);	//test addNodeAfterThis method
		
		System.out.println("Testing the addNodeAfterThis method gives: " + data1.toString());  //test toString method
		System.out.println("The linked list has the following elements staring at node 3: " + data3.toString());
		System.out.println("The length of the linked list starting at node 1 is: " + IntNode.listLength(data1));  //Testing listLength method
		System.out.println("The length of the linked list starting at node 2 is: " + IntNode.listLength(data2));
		data5.removeNodeAfterThis();
		System.out.println("Testing the removeNodeAfterThis method gives: " + data1.toString());  //Testing removeNodeAfterThis method
		System.out.println("The length of the linked list is: " + IntNode.listLength(data1));	//Testing the length of the list after removing a node
		System.out.println("The search for number 1000 returned: " + IntNode.search(data1, 1000));  //Testing search method - looking for 1000
		System.out.println("The search for number 15 returned: " + IntNode.search(data1, 15));  //Testing the search method - looking for 15
		
		data3.addNodeAfterThis(555);
		System.out.println("Testing the addNodeAfterThis method gives: " + data1.toString());  
		
		//LAB 5 TESTING
		
		System.out.println("\n");
		System.out.println("The testing for Lab 5 methods begins here:");
		System.out.println("***************************************************************");
		System.out.println("\n");
		//listEvenNumber Method
		System.out.println("Testing the listEvenNumber method we have " + IntNode.listEvenNumber(data1) + " even numbers.");
		//addToEnd Method
		data1.addToEnd(99);
		System.out.println ("Testing the addToEnd method gives: " + data1.toString());
		//sumEnd Method
		System.out.println("Testing the sumEnd method for last 3 nodes gives: " + IntNode.sumLast(data1, 3));
		System.out.println("Testing the sumEnd method for num > number of nodes (ie sum of all the nodes) gives: " + IntNode.sumLast(data1, 11));
		//copyOdd Method
		IntNode.copyOdd(data1);																			
		System.out.println("The test for copyOdd gives a new link list of: " + IntNode.copyOdd(data1));
		//removeAll Method
		System.out.println("The test for removeAll gives the following list after removing 9: " + IntNode.removeAll(data1,9));
		System.out.println("The test for removeAll gives the following list after removing 15: " + IntNode.removeAll(data1,15));
		System.out.println("The test for removeAll gives the following list after removing 99: " + IntNode.removeAll(data1,99));
		//reverse Method
		System.out.println("The reverse method gives: " + IntNode.reverse(data1));
		System.out.println("The reverse method gives: " + IntNode.reverse(data6));
		System.out.println("The reverse method gives: " + IntNode.reverse(data7));
		
		//hasCycle Method
		System.out.println("The hasCycle method gives: " + IntNode.hasCycle(data1));
		
		//create a new linked list that is cyclic
		
		IntNode data100 = new IntNode();
		data100.setData(1000);
		IntNode data200 = new IntNode();
		data200.setData(1500);
		data100.setLink(data200);
		IntNode data300 = new IntNode();
		data300.setData(700);
		data200.setLink(data300);
		IntNode data400 = new IntNode();
		data400.setData(1500);
		data300.setLink(data100);
		
		System.out.println("The hasCycle method gives: " + IntNode.hasCycle(data100));
		
		

	}

}
