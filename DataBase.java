import java.util.*;

public class DataBase {

	//Using patent ID as index
	public HashMap<String, Patent> myPtable;
		
	public String CitationNumberTablePath;
	
	public String InventorsNumberTablePath;
	
	public String inputListPath;
	
	public String outputPath;
	
	public String outputInventorPath;
	
	public String inputCApath;
	
	public String outputCApath;
	
	public String inputLawyerPath;
	
	public String outputLawyerPath;
	
	public String inputBackwardCitationPath;
	
	public String outputBackwardCitationPath;
	
	public String inputDatePath;
	
	public String outputDatePath;
	
	public String inputInvNalPath;
	
	public String outputInvNalPath;
	//singulaton 
	private static DataBase myDataBase;
	
	private DataBase(){
		//config
		this.inputListPath = new String("blockingSampleTest.csv");
		this.CitationNumberTablePath = new String("citationSampleTest.csv");
		this.InventorsNumberTablePath = new String("TableNofInventors.csv");
		this.outputPath = new String("citation2002.csv");
		this.outputInventorPath = new String("inventors2002.csv");
		this.inputCApath = new String("ClaimLawyerAssignee.tsv");
		this.outputCApath = new String("CAL2002.csv");
		this.inputLawyerPath = new String("Lawyers.tsv");
		this.outputLawyerPath = new String("Lawyers2002.csv");
		this.inputBackwardCitationPath = new String("backwardCitation.tsv");
		this.outputBackwardCitationPath = new String("backwardCitation2002.csv");
		
		this.myPtable = new HashMap<String, Patent>();
	}
	
	public static DataBase GetDataBase(){
		if(myDataBase == null){
			myDataBase = new DataBase();
		}
		return myDataBase;
	}
}
