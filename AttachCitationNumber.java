import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class AttachCitationNumber extends Procedure{

	public void Task(){
        BufferedReader reader;
        
        try {
            
            reader = new BufferedReader(new FileReader(myDB.CitationNumberTablePath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
                //clear previous inputdata
               
               
                String tmpPatentId = item[0].replace('"', ' ');
                tmpPatentId = tmpPatentId.replace(" ", "");
//                System.out.println("in attach: " + tmpPatentId);
                
                Patent tmpPatent = myDB.myPtable.get(tmpPatentId);
                
                if(tmpPatent != null){
                	/*
                	 * clean string of number
                	 * */
//                	System.out.println(item[1]);
                	String tmpCite = item[1].replace('"', ' ');
                	tmpCite = tmpCite.replace(" ", "");
//                	System.out.println(tmpCite);
                	tmpPatent.nOfCite = Integer.parseInt(tmpCite);
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
