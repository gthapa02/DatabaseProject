import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Database {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public Database() {
    	Class.forName("com.mysql.jdbc.Driver");
        
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/employee_management?"
                        + "user=root&password=");

      
        statement = connect.createStatement();
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
    public void insertRecord(String empName,String empDob, String empSalary, String empAge)  throws SQLException {
    	try {
    	 preparedStatement = connect
                 .prepareStatement("insert into  employee values (default, ?, ?, ?, ?)");
        
         preparedStatement.setString(1, empName);
         preparedStatement.setString(2, empDob);
         preparedStatement.setString(3, empSalary);
         preparedStatement.setString(4, empAge);
         preparedStatement.executeUpdate();
    	}catch(Exception e) {
    		System.out.println(e.toString());
    	}
    }
    public ResultSet retriveRecord(String table) {

        resultSet = statement
                .executeQuery("select * from "+table);
        return resultSet;
    }
    public ResultSet retriveIndividualEmployee(int id) {
    	 resultSet = statement
                 .executeQuery("select * from employee where empId ="+id);
         return resultSet;
    }
    public void updateRecord(int empId,String empName,String empDob, String empSalary, String empAge) {
   	 preparedStatement = connect
                .prepareStatement("update into  employee set empName= ?, empDob = ?, empSalary =  ?, empAge =  ?");
       
        preparedStatement.setString(1, empName);
        preparedStatement.setString(2, empDob);
        preparedStatement.setString(3, empSalary);
        preparedStatement.setString(4, empAge);
        preparedStatement.executeUpdate();
   }
    public void deleteRecord(int id) {
    	 resultSet = statement
                 .executeQuery("Delete from employee where id = "+id);
    }
    public ResultSet fileterRecord() {
    	 resultSet = statement
                 .executeQuery("select * from employee where salary >5000 and NAME LIKE 'B%' and age > 21");
         return resultSet;
    }

}