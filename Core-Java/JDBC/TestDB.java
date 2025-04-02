package hexawareTraining.practiceJDBC;
import java.sql.*;
import java.util.Scanner;
public class TestDB {
	
	static Scanner scanner=new Scanner(System.in);
 	static	void retriveRecords() throws SQLException {
		Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb","root","Baguvix@2003");
		
		Statement statment= connect.createStatement();
		ResultSet resultSet= statment.executeQuery("select * from employee");
		
		//System.out.println(resultSet);
		
		while(resultSet.next()) {
			
		System.out.println("*********************************************************");
		
		System.out.println("ID is : "+resultSet.getInt(1));
		
		System.out.println("Employee name is : "+resultSet.getString(2));
		
		System.out.println("Employee age is : "+resultSet.getInt(3));
		
		System.out.println("Employee domain name is : "+resultSet.getString(4));
		
		
		}
		connect.close();
	}
 	
 	static void insertRecordWithoutPreparedStatement() throws SQLException {
 		
 		Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb","root","Baguvix@2003");
		
		Statement statment= connect.createStatement();
		int rows= statment.executeUpdate("insert into employee values (6,'Afsal',22,'Java Developer')");
		
		System.out.println("Number of Rows Affected : "+rows);
		
		
		connect.close();
 		
 	}
 	
 	static void insertRecord() throws SQLException {
 		
 		Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb","root","Baguvix@2003");
		
 		PreparedStatement preparedStatement= connect.prepareStatement("insert into employee values (?,?,?,?);");
 		
 		while(true) {
 			System.out.println("Enter ID : ");
 			int id=scanner.nextInt();
 			scanner.nextLine();
 			
 			System.out.println("Enter Name : ");
 			String name=scanner.nextLine();
 			
 			System.out.println("Enter Age : ");
 			int age =scanner.nextInt();
 			scanner.nextLine();
 			
 			System.out.println("Enter Domain Name : ");
 			String domain=scanner.nextLine();
 			
 			
 			
 			
 			preparedStatement.setInt(1, id);
 			preparedStatement.setString(2,name);
 			preparedStatement.setInt(3, age);
 			preparedStatement.setString(4, domain);
 			
 			
 			
 			int rows=preparedStatement.executeUpdate();
 			
 			
 			System.out.println("Number of Rows Affected : "+rows);
 			
 			
 			System.out.println("Continue (yes or no) : ");
 			String choice=scanner.nextLine();
 			if(choice.equalsIgnoreCase("no")) break;
 		}
 		
 		
 		
 	}
 	
static void deleteRecord() throws SQLException {
 		
 		Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb","root","Baguvix@2003");
		
 		PreparedStatement preparedStatement= connect.prepareStatement("delete from employee where employeeId=?;");
 		
 		while(true) {
 			System.out.println("Enter ID : ");
 			int id=scanner.nextInt();
 			scanner.nextLine();
 			
 			preparedStatement.setInt(1, id);
 			int rows=preparedStatement.executeUpdate();
 			
 			System.out.println("Number of Rows Affected : "+rows);
 			
 			System.out.println("Continue (yes or no) : ");
 			String choice=scanner.nextLine();
 			if(choice.equalsIgnoreCase("no")) break;
 		}
 		
 		
 		
 	}

//has this in update record
//Exception in thread "main" com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Truncated incorrect DOUBLE value: 'DEVOPS'
static void updateRecord() throws SQLException {
		System.out.println("Update Domain by ID");
		Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb","root","Baguvix@2003");
	
		PreparedStatement preparedStatement= connect.prepareStatement("update employee set employeedomain=? where employeeId=?;");
		
		while(true) {
			System.out.println("Enter ID : ");
			int id=scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter new Domain : ");
			String newDomain=scanner.next();
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, newDomain);
			int rows=preparedStatement.executeUpdate();
			
			System.out.println("Number of Rows Affected : "+rows);
			
			System.out.println("Continue (yes or no) : ");
			String choice=scanner.nextLine();
			if(choice.equalsIgnoreCase("no")) break;
		}
		
		
		
	}



	public static void main(String[] args) throws SQLException {
		//insertRecord();
		updateRecord();
		retriveRecords();
		
		
		
	}

}
