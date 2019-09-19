

import java.io.*;
import java.util.ArrayList;

//declare variables

class alldata{
	
	String Name;
	String Num;
	String State;
	String Zip;
	int Age;
	String Sex;
}

// establish class

public class EmployeeFileOp {
	
	//instance variables
	private static ArrayList<alldata> data = null;
	private static String header;
		
	//create method to read data from data file and store data from each line in array list using filereader wrapped in bufferedreader
	
		public static void read(String fname){
			
			String line = "";
			try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = new FileReader(fname);
	            
	         // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            header=bufferedReader.readLine();
	            
	            data = new ArrayList<alldata>();

	            while((line = bufferedReader.readLine()) != null) {
	            	
	                //parse line and divide data by comma
	                
	            	
	                	String[] lineStr = line.split(",");
	                	
	                //create object row into which data from each line is stored and then added to array list	
	                	
	                if(lineStr.length >0) {
	                	alldata row = new alldata();
	                	row.Name = lineStr[0]+ "," + lineStr[1];
	                	row.Num = lineStr[2];
	                	row.State = lineStr[3];
	                	row.Zip = lineStr[4];
	                	row.Age = Integer.parseInt(lineStr[6]);
	                	row.Sex = lineStr[7];
	                	
	                	data.add(row);
	                }
	                
	               
	            }   
	            bufferedReader.close(); // Always close files.         
	        }catch(FileNotFoundException ex) {
	            System.out.println("Unable to open file '" +  fname + "'");                
	        }catch(IOException ex) {
	            System.out.println("Error reading file '" + fname + "'");                  
	        }
			System.out.println("Finish reading data from file "+ fname);
		}
		
		// create method to write data into object named file and use filewwriter to write information into object fw and store in bw using bufferedwriter
		
		public static void write(String fname){
			try {
				File file = new File(fname);
				
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				//establish variable str and call to write header row
				String str = "Employee Name, Employee Number, State, Zip, Age, Sex\n";
				bw.write(str);
				//parse the array list and retrieve data for employees of age 30 or less
				for(int i=0;i<data.size();i++){
					if(data.get(i).Age <= 30) {
					//call the information stored in the arraylist in each particular index and then call to write
					bw.write(data.get(i).Name+","+data.get(i).Num + "," + data.get(i).State + "," + data.get(i).Zip + "," + data.get(i).Age + "," + data.get(i).Sex + "\n");
				}
				}
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("Finish writing data to file "+ fname);
		}
		

			//Establish main method for reading the data set and writing the data to another file
	public static void main(String[] args) {
		
				data = null;		    //clear the memory
				read("core_dataset.csv");		//read back the data
				write("young_employee.csv"); //write the data to another file
			}		
			

	}


