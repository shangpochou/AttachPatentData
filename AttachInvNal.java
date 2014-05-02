import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class AttachInvNal extends Procedure{

	public void Task(){
		BufferedReader reader;
	        
	    try {        
	    	reader = new BufferedReader(new FileReader(myDB.inputInvNalPath));
	         
	        // Read the first line or not (comment means yes)
	        reader.readLine();
	      
	        String line = null;
	            
	        while ((line = reader.readLine()) != null) {               
	        	String item[] = line.split(",");              
	               
	            String tmpPatentId = this.ParseCSV(item[0]);
	                
//	           	System.out.println("in attach: " + tmpPatentId);
	                
	            Patent tmpPatent = myDB.myPtable.get(tmpPatentId);
	                
	            if(tmpPatent != null){
	                tmpPatent.hasForeignInventor = Integer.parseInt(this.ParseCSV(item[1]));
	                tmpPatent.OneOfInventor = this.ParseCSV(item[2]);
//	                System.out.println("in attach: " + tmpPatentId + " " + tmpPatent.nOfCite);
	                this.myDB.myPtable.put(tmpPatentId, tmpPatent);
	            }
	        }
	        reader.close();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	       } catch (IOException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       }	
	}
}
