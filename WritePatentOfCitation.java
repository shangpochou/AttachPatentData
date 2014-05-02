import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Write citation table to a .CSV file.
 */

/**
 * @author ShangpoChou
 *
 */
public class WritePatentOfCitation extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputPath)); 

		String tmpTitle = new String();
		tmpTitle = tmpTitle + '"'+"PatentID"+'"'+","+'"'+"nOfCitation"+'"';
		bw.write(tmpTitle);
	    bw.newLine();
		
		
		for(String key : myDB.myPtable.keySet()){
			Patent tmpPatent = myDB.myPtable.get(key);

			String temp = new String();
			temp = temp + '"' + tmpPatent.ID + '"' + "," + '"' + tmpPatent.nOfCite + '"';
			bw.write(temp);
			bw.newLine();
			
		}
		bw.close();
	}

}
