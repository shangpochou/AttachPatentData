import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.*;

/**
 *Read blocking data from .CSV file. 
 *Contain patentID and number of blocking
 * 
 */

/**
 * @author ShangpoChou
 *
 */
public class ReadInputPatentsList extends Procedure{
	
	public void Task(){
        BufferedReader reader;
        
        try {
            
            reader = new BufferedReader(new FileReader(myDB.inputListPath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
                //clear previous inputdata
               
                Patent myTmpPt = new Patent();
                String tmpStringID = item[0].replace('"', ' ');
                tmpStringID = tmpStringID.replace(" ", "");
                myTmpPt.ID = tmpStringID;
 //               System.out.println(myTmpPt.ID);
 //               String tmpStringYear = item[1].replace('"', ' ');
 //               tmpStringYear = tmpStringYear.replace(" ", "");
 //               myTmpPt.grantedDateObj.year = Integer.parseInt(tmpStringYear);
                
                this.myDB.myPtable.put(myTmpPt.ID, myTmpPt);     
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
/*	
	for(String key : myDB.myPtable.keySet()){
		Patent tmpP = myDB.myPtable.get(key);
		System.out.println(tmpP.ID);
	}
*/	
	}

}
