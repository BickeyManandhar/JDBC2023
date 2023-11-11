package preparedStatement;

public class MainJDBC {

	public static void main(String[] args) {
		DataBaseUtil dbu = new DataBaseUtil();
		dbu.createConnection();
		
		dbu.retriveAll();
		//dbu.retriveUsingId(8);
		//dbu.insertData(8, "Chloe", "Junior Programmar", "USA", 9898);
		//dbu.updateUsingID(8, "Chloe", "Senior Programmar", "USA", 9898);
		//dbu.deleteUsingID(8);
	}

}
