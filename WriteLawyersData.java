import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteLawyersData extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputLawyerPath)); 

		String tmpTitle = new String();
		tmpTitle = tmpTitle + '"'+"PatentID"+'"'+","+'"'+"nOfLawyers"+'"';
		bw.write(tmpTitle);
	    bw.newLine();
		
		
		for(String key : myDB.myPtable.keySet()){
			Patent tmpPatent = myDB.myPtable.get(key);

			String temp = new String();
			temp = temp + '"' + tmpPatent.ID + '"' + "," + '"' + tmpPatent.nOfLawyers + '"';
			bw.write(temp);
			bw.newLine();
			
		}
		bw.close();
	}
}
