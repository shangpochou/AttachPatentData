import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class AttachDates extends Procedure{

	
	public void Task(){
        BufferedReader reader;
        
        try {
            
            reader = new BufferedReader(new FileReader(myDB.inputDatePath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
                //clear previous inputdata
               
               
                String tmpPatentId = this.ParseCSV(item[0]);
                
//              System.out.println("in attach: " + tmpPatentId);
                
                Patent tmpPatent = myDB.myPtable.get(tmpPatentId);
                
                if(tmpPatent != null){
//                	System.out.println(item[1]);
                	
//                	System.out.println(tmpCite);
                	tmpPatent.grantedDateObj.year = Integer.parseInt(this.ParseCSV(item[1]));
                	tmpPatent.grantedDateObj.month = Integer.parseInt(this.ParseCSV(item[2]));
                	tmpPatent.grantedDateObj.date = Integer.parseInt(this.ParseCSV(item[3]));
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
