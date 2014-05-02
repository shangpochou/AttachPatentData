import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * CAL data means number of claims/number of assignee/
 * this class cloud attach these data for the given year, which is year 2002 now.
 * 
 * */
public class AttachCAdata extends Procedure {

	public void Task(){
        BufferedReader reader;
        
        try {
            
            reader = new BufferedReader(new FileReader(myDB.inputCApath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split("\t", -1);              
                //clear previous inputdata
               
               
                String tmpPatentId = item[0];
//                System.out.println("in attach: " + tmpPatentId);
                
                Patent tmpPatent = myDB.myPtable.get(tmpPatentId);
                
                if(tmpPatent != null){
                	tmpPatent.nOfClaims = Integer.parseInt(item[1]);
                	tmpPatent.nOfassignee = Integer.parseInt(item[2]);
                	tmpPatent.nOfLawyers = Integer.parseInt(item[3]);
//                	System.out.println("in attach: " + tmpPatentId + " " + tmpPatent.nOfCite);
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


