import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteDates extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputDatePath)); 

		String tmpTitle = new String();
		tmpTitle = tmpTitle + '"'+"PatentID"+'"'+","+'"'+"Year"+'"' + "," + '"' + "Month" + '"' + "," + '"' + "Date" + '"';
		bw.write(tmpTitle);
	    bw.newLine();
		
		
		for(String key : myDB.myPtable.keySet()){
			Patent tmpPatent = myDB.myPtable.get(key);

			String temp = new String();
			temp = temp + '"' + tmpPatent.ID + '"' + "," + '"' + tmpPatent.grantedDateObj.year + '"' + "," + '"' + tmpPatent.grantedDateObj.month + '"' + "," + '"' + tmpPatent.grantedDateObj.date + '"';
			bw.write(temp);
			bw.newLine();
			
		}
		bw.close();
	}
}
