package homeWork;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Scanner;

public class main {
	 private ResultSet resultSet = null;
	
	  public static void main(String[] args) throws Exception {
		  
		  try {
	        Database dao = new Database();
	        Scanner sc = new Scanner(System.in);
	        
	        //Insert Code
	        
	        System.out.println("Enter employee name");
	        String empName = sc.nextLine();
	        System.out.println("Enter employee dob");
	        String empDob = sc.nextLine();
	        System.out.println("Enter employee salary");
	        String empSalary = sc.nextLine();
	        System.out.println("Enter employee age");
	        String empAge = sc.nextLine();
	        dao.insertRecord(empName, empDob, empSalary, empAge);
	        
	        //select code 
	        
	        ResultSet resultSet = dao.retriveRecord(empAge);
	        while (resultSet.next()) {
	            String employeeName = resultSet.getString("emp_name");
	            String dob = resultSet.getString("emp_dob");
	            String salary = resultSet.getString("emp_salary");
	            String age = resultSet.getString("emp_age");
	     
	            System.out.println("Employee Name: " + employeeName);
	            System.out.println("Dob " + dob);
	            System.out.println("Salary: " + salary);
	          
	            System.out.println("Age: " + age);
	        }
	        
	        //individual select
	        
	        System.out.println("Enter individual employee id:");
	        int id = sc.nextInt();
	        dao.retriveIndividualEmployee(id);
	        
	        //update code
	        
	        System.out.println("Enter updating employee id:");
	        id = sc.nextInt();
	        dao.retriveIndividualEmployee(id);
	        
	        System.out.println("Enter new employee name");
	        empName = sc.nextLine();
	        System.out.println("Enter new n employee dob");
	        empDob = sc.nextLine();
	        System.out.println("Enter new employee salary");
	        empSalary = sc.nextLine();
	        System.out.println("Enter new employee age");
	        empAge = sc.nextLine();
	        dao.updateRecord(id,empName, empDob, empSalary, empAge);
	        
	        //delete code
	        
	        System.out.println("Enter deleting employee id:");
	        id = sc.nextInt();
	        dao.deleteRecord(id);
	        
	        //filter code
	        
	        resultSet = dao.fileterRecord();
	        while (resultSet.next()) {
	            String employeeName = resultSet.getString("emp_name");
	            String dob = resultSet.getString("emp_dob");
	            String salary = resultSet.getString("emp_salary");
	            String age = resultSet.getString("emp_age");
	     
	            System.out.println("Employee Name: " + employeeName);
	            System.out.println("Dob " + dob);
	            System.out.println("Salary: " + salary);
	          
	            System.out.println("Age: " + age);
	        }
	        
	        dao.close();
	        //application end 
	        
	        System.out.println("Application End. Thank you!");
	        
		  }catch(Exception e) {
			  System.out.println(e.toString());
		  }
	        
	    }

}
