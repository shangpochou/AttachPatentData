import java.util.ArrayList;

/*
 * Given a .CSV file contain a list, which is patents in certain year,
 * it could return a table of these patens with number of citations.
 * 
 * */
public class AttachPatentData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase myDB = DataBase.GetDataBase();
		
		ArrayList<Procedure> myProcAL = new ArrayList<Procedure>();
		
		ReadInputPatentsList myRIPL = new ReadInputPatentsList();
		myProcAL.add(myRIPL);
		
		AttachCitationNumber myACN = new AttachCitationNumber();
		myProcAL.add(myACN);
		
		WritePatentOfCitation myWPOC = new WritePatentOfCitation();
		myProcAL.add(myWPOC);
		
		AttachInventorsNumber myAIN = new AttachInventorsNumber();
		myProcAL.add(myAIN);
		
		WritePatentOfInventors myWPOI = new WritePatentOfInventors();
		myProcAL.add(myWPOI);
		
		AttachCAdata myACA = new AttachCAdata();
		myProcAL.add(myACA);
		
		WriteCALPatentData myWCPD = new WriteCALPatentData();
		myProcAL.add(myWCPD);
		
		AttachLawyersData myALD = new AttachLawyersData();
		myProcAL.add(myALD);
		
		WriteLawyersData myWLD = new WriteLawyersData();
		myProcAL.add(myWLD);
		
		for(int i = 0; i < myProcAL.size(); i++){
			myProcAL.get(i).GetData(myDB);
			myProcAL.get(i).Task();
		}
		
		
	}

}
