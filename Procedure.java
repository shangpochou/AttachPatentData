/**
 * Base class for different procedures.
 * Using template method
 */

/**
 * @author ShangpoChou
 *
 */


public class Procedure {
	
	protected DataBase myDB;
	
	public void GetData(DataBase inputDB){
		this.myDB = inputDB;
	}
	public void Task(){
		
	}
	
	protected String ParseCSV(String inputString){
		String newString = inputString.replace('"', ' ');
		newString = newString.replace(" ", "");
		return newString;
	}
	
}
