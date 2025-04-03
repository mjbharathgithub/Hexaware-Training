package hexawareTraining.practiceJDBC;

import java.sql.SQLException;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			TestDB db = new TestDB();
//			db.retriveRecords();
			db.getTechiesDomainById();
//			db.techiesCall_SP();
//			
//			db.retriveRecords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
