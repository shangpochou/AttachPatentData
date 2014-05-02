import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class WriteInvNal extends Procedure{
	public void Task(){
		try {
			Output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Output() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(myDB.outputInvNalPath)); 

		String tmpTitle = new String();
		tmpTitle = tmpTitle + '"'+"PatentID"+'"'+","+'"'+"hasForeInv"+'"' +"," + '"' + "OneOfNal" + '"';
		bw.write(tmpTitle);
	    bw.newLine();
		
		
		for(String key : myDB.myPtable.keySet()){
			Patent tmpPatent = myDB.myPtable.get(key);

			String temp = new String();
			temp = temp + '"' + tmpPatent.ID + '"' + "," + '"' + tmpPatent.hasForeignInventor + '"' + "," + '"' + tmpPatent.OneOfInventor + '"';
			bw.write(temp);
			bw.newLine();
			
		}
		bw.close();
	}
}


