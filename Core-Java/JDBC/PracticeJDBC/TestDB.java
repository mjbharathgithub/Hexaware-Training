package hexawareTraining.practiceJDBC;
import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.conf.ConnectionUrl.Type;
public class TestDB {


 	private final static	String PASSWORD=System.getenv("DB_PASSWORD");
 	private final static	String URL=System.getenv("DB_URL");
 	private final static	String USER=System.getenv("DB_USER");
 	private final static	String DB_NAME="firstdb";
 	private final 	Connection connect;
	
	TestDB() throws SQLException {
	connect= DriverManager.getConnection(URL+DB_NAME,USER,PASSWORD);
	}
	static Scanner scanner=new Scanner(System.in);
 		void retriveRecords() throws SQLException {

 			
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
 	
 	 void insertRecordWithoutPreparedStatement() throws SQLException {

		Statement statment= connect.createStatement();
		int rows= statment.executeUpdate("insert into employee values (6,'Afsal',22,'Java Developer')");
		
		System.out.println("Number of Rows Affected : "+rows);
		
		
		connect.close();
 		
 	}
 	
 	 void insertRecord() throws SQLException {


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
 	
	 void deleteRecord() throws SQLException {


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


	public void updateRecord() throws SQLException {

			PreparedStatement preparedStatement= connect.prepareStatement("update employee set employeedomain=? where employeeId=?;");
			
			while(true) {
				System.out.println("Enter ID : ");
				int id=scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter new Domain : ");
				String newDomain=scanner.next();
				
				preparedStatement.setInt(2, id);
				preparedStatement.setString(1, newDomain);
				int rows=preparedStatement.executeUpdate();
				
				System.out.println("Number of Rows Affected : "+rows);
				
				System.out.println("Continue (yes or no) : ");
				String choice=scanner.nextLine();
				if(choice.equalsIgnoreCase("no")) break;
			}
			
			
			
		}

		public  void techiesCall_SP() throws SQLException {
			
			CallableStatement callableStatement = connect.prepareCall("{call getTechiesName()}");
			
			ResultSet resultSet= callableStatement.executeQuery();
			System.out.println("Techies Name");
			
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
			
			
		}
	
	public  void techieCallById_SP() throws SQLException {
		
		
		CallableStatement callableStatement = connect.prepareCall("{call getTechieNameByid(?)}");
		
		
		while(true) {
			
		System.out.println("Enter the id : ");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		callableStatement.setInt(1, id);
		
		ResultSet resultSet= callableStatement.executeQuery();
		
		resultSet.next();
		
		System.out.println("Techy's Detail");
		
		System.out.println("ID is : "+resultSet.getInt(1));
		
		System.out.println("Employee name is : "+resultSet.getString(2));
		
		System.out.println("Employee age is : "+resultSet.getInt(3));
		
		System.out.println("Employee domain name is : "+resultSet.getString(4));
		System.out.println("Continue?\nYes or NO : ");
		String choice=scanner.next();
		
		if(choice.equalsIgnoreCase("no")) break;
		
		}
		connect.close();
		System.out.println("\n\nStored Procedure Called Successfully");
	}
	
	
	public void getTechiesDomainById() throws SQLException {
		
		CallableStatement callableStatement= connect.prepareCall("{call getTechiesDomain(?,?)}");
		
		while(true) {
		System.out.println("Enter the id : ");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		callableStatement.setInt(1, id);
		callableStatement.registerOutParameter(2, Types.VARCHAR);
		
		callableStatement.executeUpdate();
		
		String domain=	callableStatement.getString(2);
		
		System.out.println(" ID : "+id+" Domain : "+domain);
		
		System.out.println("Continue?\nYes or NO : ");
		String choice=scanner.next();
		
		if(choice.equalsIgnoreCase("no")) break;
		}
		System.out.println("Output Stored Procedure is called successfully");
	}


	public void multipleQuery_BatchProcessing() throws SQLException {
		String query1,query2,query3,query4;
		
		query1="update employee set employeeage=31 where employeeId=1;";
		query2="update employee set employeeage=222 where employeeId=2;";
		query3="update employee set employeeage=300 where employeeId=3;";
		query4="update employee set employeeage=400 where employeeId=4;";
		
		connect.setAutoCommit(false);
		
		Statement statement= connect.createStatement();
		
		
		statement.addBatch(query1);
		statement.addBatch(query2);
		statement.addBatch(query3);
		statement.addBatch(query4);
		
		int result[]=statement.executeBatch();
		
		for(int ele: result) {
			if(ele<1) connect.rollback();
			
		}
		
		connect.commit();
		
		
		System.out.println("Batches executed successfully\n");
		
		//this.retriveRecords();
	}


}
