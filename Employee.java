
public class Employee {
	
	//This class is designed to keep track of a variety of employee information
	// 1.  declare instance variables for the types of information that will be stored for each employee	
	
	private String employeeName;
	private int employeeNo;
	private int employeeAge;
	private String employeeState;
	private int employeeZipCode;
	private int employeeAdvisorNos [];
	
	/* 2(i).  default or no-argument constructor to initialize each instance variable to its 
	          initialization value or default value*/
	
	public Employee () {
		employeeName = "";
		employeeNo = 0;
		employeeAge = 0;
		employeeState = "";
		employeeZipCode = 0;
		employeeAdvisorNos = new int [3];;
		
	}

	/* 2(ii).  copy constructor is a constructor that creates an object by initializing it with 
	 * an object of the same class that has already been created, thus in effect making a copy of 
	 * that object*/
	
	public Employee (Employee obj) {
		//check to make sure object to be copied exists and is member of same class
		if(obj==null) return;
		if(obj instanceof Employee) {
			//type cast the new object
			Employee emp = (Employee) obj;
			/*initialization of new object being careful with String elements by creating a new 
			 * String object and being careful with integer array by creating new integer array
			 * and copying each element to the new array with a for loop
			 */
			employeeName = new String (emp.employeeName);
			employeeNo = emp.employeeNo;
			employeeAge = emp.employeeAge;
			employeeState = new String (emp.employeeState);
			employeeZipCode = emp.employeeZipCode;
			employeeAdvisorNos = new int [3];
				for (int i = 0; i < employeeAdvisorNos.length; i++) { //copy each element to new array 
					employeeAdvisorNos[i]=emp.employeeAdvisorNos[i];
				}
		}
		else {
			return;
		}
	}
	
	// 2(iii).  the get and set methods for all the instance variables
	
	//accessor or get methods
	
	public String getEmployeeName() {
		return employeeName;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public int getEmployeeAge() {
		return employeeAge;
	}
	public String getEmployeeState() {
		return employeeState;
	}
	public int getEmployeeZipCode() {
		return employeeZipCode;
	}
	public int[] getEmployeeAdvisorNos() {
		return employeeAdvisorNos;
		}
	
	// mutator or set methods
	
	public void setEmployeeName(String name) {
		employeeName = name;
	}
	public void setEmployeeNo(int no) {
		employeeNo = no;
	}
	public void setEmployeeAge(int age) {
		employeeAge = age;
	}
	public void setEmployeeState(String state) {
		employeeState = state;
	}
	public void setEmployeeZipCode(int zipCode) {
		employeeZipCode = zipCode;
	}
	public void setEmployeeAdvisorNos(int[] advisorNos) {
		//employeeAdvisorNos = advisorNos;
		for (int i = 0; i<advisorNos.length; i++) {
			employeeAdvisorNos[i] = advisorNos[i];
		}
	}
	
	// 2(iv).  toString method to generate a string representation of an employee
	
	public String toString() {
		String info = "";
		info = " Employee Name: " + employeeName + "\n " + "Employee No: " + employeeNo + "\n " + "Employee Age: " + employeeAge + "\n " +
		"Employee State: " + employeeState + "\n " + "Employee Zip Code: " + employeeZipCode + "\n " + "Employee Advisor No(s): " 
				+ employeeAdvisorNos[0] + ", "+ employeeAdvisorNos[1] + ", "+ employeeAdvisorNos[2]+ "\n";
		
		return info;
	}
	
	/* 2(v).  Equals method to check if employee no of given object is the same as the employee instance that activates the method,
	 * will return a true or false answer
	 */
	
	public boolean equals(Employee obj) {
		//make sure object exists and is part of same class
		if (obj != null) {  
		if (obj instanceof Employee) {
			//type cast the object
			Employee emp = (Employee) obj;
			if (emp.employeeNo == employeeNo) {
				return true;
			}
		}
		}
		return false;
		
	}
	
	/* 2(vi).  static method getAllAdvisors to get all the distinct advisor numbers of
	 * two employees which are the input parameters
	 */
	
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		//check to see if both employees have data
		if ((e1 == null) && (e2 == null)) {
			return null;
		}
		//establish new array to house id nos from all advisors for 2 employees
		int[] temp = new int[6];
		int k = 0;
		//loop through first array and pull out all advisor id numbers and store in new array called temp
		for (int i = 0; i<e1.employeeAdvisorNos.length; i++)	
		{
			temp[k]=e1.employeeAdvisorNos[i];
			k++;
		}
			
			for (int j = 0; j<e2.employeeAdvisorNos.length; j++)
			{
				boolean is_equal = false;
				//loop through first array and compare each element of the second array with each element of the first array
				for(int x = 0; x<e1.employeeAdvisorNos.length; x++)
				{
					if(e2.employeeAdvisorNos[j]==e1.employeeAdvisorNos[x])
					{
						is_equal = true;
						break;
					}
				}
					//if two elements are not the same, then store the new element from the second array into the temporary array
					if(! is_equal) 
					{
						temp[k]=e2.employeeAdvisorNos[j];
						k++;
						
					}
				}
			
			return temp;
	}
	
	
	//Main Method for testing
	
	public static void main(String[] args) {
		// Test Constructor
		
		System.out.println("Testing the Constructor for Employees e1 and e2 gives the following result:" + "\n");
		
		Employee e1 = new Employee();
		//need to create an integer array for e1
		int[] a = {300,400,500};
		e1.setEmployeeName("Lovemore");
		e1.setEmployeeNo(60);
		e1.setEmployeeAge(35);
		e1.setEmployeeState("Arizona");
		e1.setEmployeeZipCode(85745);
		e1.setEmployeeAdvisorNos(a);
		System.out.println(e1);
		
		Employee e2 = new Employee();
		//need to create an integer array for e2
		int[] b = {600,700,800};
		e2.setEmployeeName("Rami");
		e2.setEmployeeNo(255);
		e2.setEmployeeAge(99);
		e2.setEmployeeState("Alaska");
		e2.setEmployeeZipCode(00046);
		e2.setEmployeeAdvisorNos(b);
		System.out.println(e2);
		
		
		// test copy constructor
		
		System.out.println("Testing the CopyConstructor to create a copy of e1 gives:" + "\n");
		
		Employee e3 = new Employee(e1);
		//System.out.println(e3);
		
		e1.toString();
		System.out.println(e1);
		/*e2.toString();
		System.out.println(e2);*/
		e3.toString();
		System.out.println(e3);
		
		
		//test equals method
		
		System.out.println("Testing the Equals Method for Employees e1 and e2 gives the following result:" + "\n");
		
		System.out.println(e1.equals(e2));
		System.out.println();
		
		//test getAllAdvisor Method
		
		System.out.println("Testing the getAllAdvisors Method for Employees e1 and e2 gives the following result:" + "\n");
		
		int [] advisors = getAllAdvisors(e1, e2);
		for (int i = 0; i<advisors.length; i++) {
			System.out.print(" " + advisors[i] + "\n");
		}

	}

}
