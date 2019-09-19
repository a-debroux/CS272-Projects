import java.io.BufferedReader;
import java.io.*;

public class EmployeeSet {
	
	/*EmployeeSet is a collection of Employee data of a variety of data types for an integer number of employees
	 * Limitations:
	 * (a) The capacity of one of these sets can change after it is created, but the maximum capacity is limited 
	 * by the amount of free memory available on the computer.  The constructors and add methods will result
	 * in an OutOfMemoryError when the free memory is all used up.
	 * (b) The set's capacity cannot exceed the largest integer (2,147,483,647) or will result in failure due to overflow.
	 * (c) Because this set is an array collection, large sets will have poor performance.
	 */
	
	/*1. Instance variables to keep all the distinct employee objects as well as to keep track of the 
	 * number of employees in the set. 
	 */
	// to keep track of each distinct employee object we use the following instance variable
	private Employee [] empData;
	//and to keep track of the number of employees in each set we use the following instance variable
	private int manyItems;
	private static String header;
	
	/*2. A no argument constructor which initializes an EmployeeSet instance and sets its capacity to 10
	 * and creates an array to store 10 employee objects.
	 */
	public EmployeeSet() {
		final int Initial_Capacity = 10;
		manyItems = 0;
		empData = new Employee[Initial_Capacity];
	}
	
	/*3. A copy constructor which creates a new EmployeeSet instance and copies the content of the given object to the new
	 * instance
	 */
	public EmployeeSet(EmployeeSet obj) {
		//check to make sure object to be copied exists and is member of same class
		if(obj==null) return;
		if(obj instanceof EmployeeSet) {
			//type cast the new object
			EmployeeSet a = (EmployeeSet) obj;
			manyItems = a.manyItems;
			empData = new Employee [a.empData.length];
			for(int i = 0; i < manyItems; i++) {
				empData[i]= new Employee(a.empData[i]);
			}
	}
		else {
			return;
		}
	}

	//4.  method that returns the actual number of elements in this set
	
	public int size() {
		return manyItems;
	}
	
	//5.  Method to return the capacity of the set
	public int capacity() {
		return empData.length;
	}
	
	/*6.  A method that adds one given employee object to the first available space to the employee array in this EmployeeSet instance.
	 * When the collection space is sufficient to hold the new employee, this employee can be directly added to the set.  Otherwise, 
	 * double the space of the instance array by implementing a method ensureCapacity.
	 * Precondition is that the employee object cannot be null
	 */
	public void add(Employee a) {
		//check to see if employee object is null, if so need to throw an exception, but when I did this here it did not work
		if(a==null) return;
		//check to see if the collection space is enough to hold the new employee and increase the capacity by calling the 
		//ensure capacity method if the collection space is not large enough, otherwise the employee gets added
		if(manyItems==empData.length) {
			ensureCapacity(manyItems*2+1);
		}
		
		//check to see if employee object already in collection and if not then add
		if (contains(a)==false){
		empData[manyItems]= a;
		manyItems++;
		}	
	}
	
	/*7.  A method to check whether the set contains the input parameter.
	 * If a is null, directly return false; if a is not null, if the set contains an object which
	 * equals a, then return true, otherwise return false.
	 */
	public boolean contains(Employee a) {
		if(a==null) return false;
		for(int i = 0; i < manyItems; i++) {
			if(a.getEmployeeNo()==empData[i].getEmployeeNo()) {
				return true;
			}
		}
			return false;
		}

	
	/*8.  A method to remove from the set the employee with the given employee no eno
	 * If a is a null object, directly return false;
	 * if a is not a null object, if the set contains one employee object a1 whose employee no is equal to eno,
	 * then remove a1 from the set and return true;
	 * otherwise do nothing and return false.
	 */
	
	public boolean remove(int eno) {
		int index;//location of target in integer array
		index = 0;
		while((index < manyItems) && (eno != empData[index].getEmployeeNo())){  //parse through array comparing target with employee no of each employee object
			index++;
			if(index == manyItems) {  //if get to the end and still have not found target, then return false
				return false;
			}
		}
				empData[index]= empData[manyItems-1];  //if target is found then remove and move everything forward from the end
				empData[manyItems-1]= null;
				manyItems--;
				return true;
			}
	
	
	/*9.  Method that guarantees the capacity of the set.  If the set's capacity is smaller than the input parameter,
	 * this method sets the capacity to minimumCapacity and enlarges the array to hold minimumCapacity objects, otherwise 
	 * the collection is left unchanged.
	 * Precondition: minimumCapacity > 0
	 */
	private void ensureCapacity(int minimumCapacity) {
		Employee[] biggerArray;
		if(minimumCapacity<=0) return;  //make sure capacity is not negative
		if(empData.length < minimumCapacity) { //if size of collection is too small, then
			biggerArray = new Employee[minimumCapacity]; //set up a larger space
			System.arraycopy(empData, 0, biggerArray, 0, manyItems);  //and copy the data over (since we are working with arrays)
			empData = biggerArray;
		}
		
	}

	/*10.  A method which adds one employee object to this EmployeeSet instance such that the objects
	 * in the employee array are in ascending order of employee nos.
	 */
	public void addOrdered(Employee a) {
		/*preconditions: (1)employee object should not be null; (2) objects in collections employee array are already
		 * in ascending order by employee no
		 */
			if(a==null) return;  //make sure employee object is not empty
				
			for(int i = 0; i < manyItems; i++) {  
				if((empData[i].getEmployeeNo()) > (empData[i+1].getEmployeeNo())) {  //already in the collection
				return;
				}
				}
					if(manyItems==empData.length) {
						ensureCapacity(manyItems*2+1);
					}

			for(int i = 0; i < manyItems;i++) {
				if((a.getEmployeeNo() <= empData[i].getEmployeeNo())) {  //parse through collection and compare employee number with the numbers of employees
					for(int j = manyItems-1; j > i; j--) {    //if the if statement is true then move elements forward starting at the end of the collection
						empData[j+1]=empData[j];
						
					}
					//empData[i+1]=empData[i];
					//empData[i]=empData[a.getEmployeeNo()];
				}
				empData[i] = a;  //place the employee object into the collection
				manyItems++;
				break;
			}
					
					/*for(int i = 0; i < manyItems;i++) {
						for(int j = 1; j < manyItems; j++) {
							if(((a.getEmployeeNo() <= empData[i].getEmployeeNo())) && (j > i)) {
								empData[j+1]=empData[j];
								empData[i+1]=empData[i];
							}
						}
						
						empData[i]= a;
						manyItems++;
						break;
					}*/
		
			}	
	
		
		public static EmployeeSet read(String fname){
			
			EmployeeSet a = new EmployeeSet();

			String line = "";
			try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = new FileReader(fname);
	            
	         // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            header=bufferedReader.readLine();
	            
	            //data = new ArrayList<alldata>();

	            while((line = bufferedReader.readLine()) != null) {
	            	
	                //parse line and divide data by comma
	                
	            	
	                	String[] lineStr = line.split(",");
	                	
	                //create object row into which data from each line is stored and then added to array 	
	                	
	                if(lineStr.length >0) {
	                	Employee row = new Employee();
	                	row.setEmployeeName( lineStr[0]+ "," + lineStr[1]);
	                	row.setEmployeeNo(Integer.parseInt(lineStr[2]));
	                	row.setEmployeeState(lineStr[3]);
	                	row.setEmployeeZipCode(Integer.parseInt(lineStr[4]));
	                	row.setEmployeeAge(Integer.parseInt(lineStr[6]));
	                	//row.Sex = lineStr[7];
	                	
	                	a.add(row);
	                }
	               
	            }   
	            bufferedReader.close(); // Always close files.         
			}catch(FileNotFoundException ex) {
	            System.out.println("Unable to open file '" +  fname + "'");                
	        }catch(IOException ex) {
	            System.out.println("Error reading file '" + fname + "'");                  
	        }
			System.out.println("Finish reading data from file "+ fname);
			 return a;
		}
		
		
		
	                  
	            public static void main(String[] args) throws Exception{
	            	
					// Test Constructor
	            	System.out.println("Testing the Void Constructor yields " + "\n");
	            	EmployeeSet s1 = new EmployeeSet();
	            	EmployeeSet s2 = new EmployeeSet();
	            	
	            	Employee e1 = new Employee();
	            	int[] a = {300,400,500};
	            	e1.setEmployeeName("Lovemore");
	        		e1.setEmployeeNo(60);
	        		e1.setEmployeeAge(35);
	        		e1.setEmployeeState("Arizona");
	        		e1.setEmployeeZipCode(85711);
	        		e1.setEmployeeAdvisorNos(a);
	            	
	            	Employee e2 = new Employee();
	            	int[] b = {600,700,800};
	        		e2.setEmployeeName("Rami");
	        		e2.setEmployeeNo(255);
	        		e2.setEmployeeAge(99);
	        		e2.setEmployeeState("Alaska");
	        		e2.setEmployeeZipCode(00046);
	        		e2.setEmployeeAdvisorNos(b);
	            	
	            	Employee e3 = new Employee();
	            	int[] c = {100,200,900};
	        		e3.setEmployeeName("Anna");
	        		e3.setEmployeeNo(400);
	        		e3.setEmployeeAge(22);
	        		e3.setEmployeeState("Massachusetts");
	        		e3.setEmployeeZipCode(85745);
	        		e3.setEmployeeAdvisorNos(c);
	            	
	            	Employee e4 = new Employee();
	            	int[] d = {600,700,800};
	        		e4.setEmployeeName("Patrick");
	        		e4.setEmployeeNo(250);
	        		e4.setEmployeeAge(50);
	        		e4.setEmployeeState("Montana");
	        		e4.setEmployeeZipCode(00046);
	        		e4.setEmployeeAdvisorNos(d);
	            	
	        		//3. test copy constructor
	            	EmployeeSet s3 = new EmployeeSet(s1);
	            	System.out.println("Testing the copy constructor to create a copy of s1 yields:  " + s3);
	            	
	            	
	            	//4. test the size
	            	System.out.println("The number of elements in the set are/is: " + s1.size());
	            	
	            	//5. test the capacity
	            	System.out.println("The capacity of this Employee Set is: " + s1.capacity());
	            	
	            	//6. testing add method
	            	s1.add(e1);
	            	System.out.println("Testing add method for adding first employee object e1: \n"+ e1);
	            	s1.add(e2);
	            	System.out.println("Testing add method for adding second employee object e2: \n"+ e2);
	            	s2.add(e3);
	            	System.out.println("Testing add method for adding first employee object e3: \n"+ e3);
	            	s2.add(e4);
	            	System.out.println("Testing add method for adding second employee object e4: \n"+ e4);
	            	System.out.println("The number of elements in the set are/is: " + s1.size());
	            	
	            	
	            	//7. testing contains method
	            	System.out.print("\n");
	            	System.out.println("Testing the contains method yields the following;");
	            	System.out.println("Set S1 contains employee object e1: " + s1.contains(e1) );
	            	System.out.println("Set S1 contains employee object e4: " + s1.contains(e4) );
	            	
	            	//8. test remove method
	            	System.out.print("\n");
	            	System.out.println("Testing the remove method yields the following:");
	            	System.out.println("Set S1 contained an employee with employee no 60 and was removed: " + s1.remove(60));
	            	System.out.println("Set S1 contained an employee with employee no 250 and was removed: " + s1.remove(250));
	            	System.out.println("Set S2 contained an employee with employee no 250 and was removed: " + s2.remove(250));
	            	
	            	//9. test ensureCapacity method
	            	
	            	
	            	//10. test addOrdered method
	            	s1.add(e1);
	            	s1.addOrdered(e2);
	            	s1.addOrdered(e3);System.out.println("Cannot find error in addOrdered method");
	            	
	            	
	            	System.out.println("\n");
	            	System.out.println("Testing the reading of the CSV file:");
	            	
	            	EmployeeSet z = new EmployeeSet(read("core_dataset.csv"));
	            	System.out.println("The number of elements in the set are/is: " + z.size());
	            	System.out.println("The capacity of this Employee Set is: " + z.capacity());
	            	System.out.println("Testing add method for adding employee object e1: \n"+ z);
	            	z.add(e2);
	            	System.out.println("The number of elements in the set are/is: " + z.size());
	            	System.out.println("Set Z contains employee object e1: " + z.contains(e1) );
	            	System.out.println("Set Z contained an employee with employee no 60 and was removed: " + z.remove(60));
	            	
	}
			
}
